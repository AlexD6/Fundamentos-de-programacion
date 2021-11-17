# -*- coding: utf-8 -*-
'''
Created on 20 nov. 2020

@author: alegestor
'''
# -*- coding: utf-8 -*-

import csv
# from matplotlib import pylab as plt
from collections import namedtuple, Counter

Videojuego = namedtuple(
    "Videojuego", "rank,name,platform,year,genre,publisher,na_sales,eu_sales,jp_sales,other_sales,global_sales")


def lee_juegos(fichero):
    videojuegos = []
    with open(fichero, encoding='utf-8') as f:
        lector = csv.reader(f, delimiter=',')
        next(lector)  # Saltar cabecera del archivo
        for rank, name, platform, year, genre, publisher, na_sales, eu_sales, jp_sales, other_sales, global_sales in lector:
            tupla_videojuego = Videojuego(int(rank), name, platform, int(year), genre, publisher, float(
                na_sales), float(eu_sales), float(jp_sales), float(other_sales), float(global_sales))
            videojuegos.append(tupla_videojuego)
    return videojuegos


def num_juegos_mas_ventasJP(lista_juegos):
    total = 0
    for vd in lista_juegos:
        if vd.jp_sales > vd.na_sales:
            total += 1
    return total
    # return len([vd for vd in lista_juegos if vd.jp_sales > vd.na_sales])


def juegos_distribuidora_anyo(lista_juegos, publisher, anyo):
    res = []
    for vd in lista_juegos:
        if vd.publisher == publisher and vd.year == anyo:
            res.append(vd)
    return res
    # return [vd for vd in lista_juegos if vd.publisher == publisher and vd.anyo == anyo]


def num_distribuidoras(lista_juegos):
    res = set()
    for vd in lista_juegos:
        res.add(vd.publisher)
    return len(res)
    # return len({vd.publisher for vd in lista_juegos})


def juego_mas_antiguo(lista_juegos):
    res = []
    año_mas_antiguo = min([vd.year for vd in lista_juegos])
    for vd in lista_juegos:
        if vd.year == año_mas_antiguo:
            res.append(vd)
    return res
    # return [vd for vd in lista_juegos if vd.year == año_mas_antiguo]


def genero_mas_presente(lista_juegos):
    dicc_conteo_generos = Counter(vd.genre for vd in lista_juegos)  # Dicionario que asocia genero con cantidad
    # dicc_conteo_generos = dict()
    # for vd in lista_juegos:
    #     if vd.genre in dicc_conteo_generos:
    #         dicc_conteo_generos[vd.genre] += 1
    #     else:
    #         dicc_conteo_generos[vd.genre] = 1
    return max(dicc_conteo_generos.items(), key=lambda x: x[1])


def genero_mas_ventas(lista_juegos):
    dicc = dict()
    for vd in lista_juegos:
        if vd.genre in dicc:
            dicc[vd.genre] += vd.global_sales
        else:
            dicc[vd.genre] = vd.global_sales
    return max(dicc.items(), key=lambda x: x[1])


def num_juegos_palabra(lista_juegos, palabra):
    total = 0
    for vd in lista_juegos:
        if palabra in vd.name:
            total += 1
    return total
    # return len([vd for vd in lista_juegos if palabra in vd.name])


def mayor_dif_NA_EU(lista_juegos):
    res = lista_juegos[0].name
    mayor_dif = lista_juegos[0].eu_sales - lista_juegos[0].na_sales
    for vd in lista_juegos:
        dif = vd.eu_sales - vd.na_sales
        if dif > mayor_dif:
            mayor_dif = dif
            res = vd.name
    return res
    # Otra forma: un diccionario que asocie nombre con la diferencia y obtener el max de esa


def ventas_por_año(lista_juegos):
    dicc = dict()
    for vd in lista_juegos:
        if vd.year in dicc:
            dicc[vd.year] += vd.global_sales
        else:
            dicc[vd.year] = vd.global_sales
    return sorted(dicc.items(), key=lambda x: x[1], reverse=True)

def dicc_porcentaje_ventasJP_por_año(lista_juegos):
    dicc = dict()
    ventas_global = dict(ventas_por_año(lista_juegos))
    ventas_japon = dict(ventas_por_año_jp(lista_juegos))
    for año, value in ventas_global.items():
        porcentaje = 100 * ventas_japon[año] / value
        if año in dicc:
            dicc[año] += porcentaje
        else:
            dicc[año] = porcentaje
    return dict(sorted(dicc.items()))

# Función auxiliar:


def ventas_por_año_jp(lista_juegos):
    dicc = dict()
    for vd in lista_juegos:
        if vd.year in dicc:
            dicc[vd.year] += vd.jp_sales
        else:
            dicc[vd.year] = vd.jp_sales
    return sorted(dicc.items(), key=lambda x: x[1], reverse=True)


def incremento_ventas(lista_juegos):
    ventas_globales = sorted(ventas_por_año(lista_juegos))
    ventas_globales_siguiente = sorted(ventas_por_año(lista_juegos))[1:]
    res = []
    for año_actual, año_siguiente in zip(ventas_globales, ventas_globales_siguiente):
        porcentaje = (año_siguiente[1] - año_actual[1]) / año_actual[1] * 100  # Se resta 1 porque se está averiguando el incremento/decremento
        res.append(porcentaje)
    return res


def juego_mas_ventas_globales_saga(lista_juegos, saga):
    lista_juegos_filtrada = [vd for vd in lista_juegos if saga in vd.name]
    juego = max(lista_juegos_filtrada, key=lambda x: x.global_sales)
    return (juego.global_sales, juego.name, juego.year)


def dicc_ventas_por_zona(lista_juegos, anyo_inicial=None, anyo_final=None):
    dicc = dict()
    dicc['América'] = 0
    dicc['Europa'] = 0
    dicc['Japón'] = 0
    dicc['Otros'] = 0
    if anyo_inicial != None:
        lista_juegos = [vd for vd in lista_juegos if vd.year >= anyo_inicial]
    if anyo_final != None:
        lista_juegos = [vd for vd in lista_juegos if vd.year <= anyo_final]
    for vd in lista_juegos:
        dicc['América'] += vd.na_sales
        dicc['Europa'] += vd.eu_sales
        dicc['Japón'] += vd.jp_sales
        dicc['Otros'] += vd.other_sales
    return dicc


def dicc_top_n_juegos_por_genero(lista_juegos, n=1):
    dicc = dict()
    for vd in lista_juegos:
        if vd.genre in dicc:
            dicc[vd.genre].append((vd.rank, vd.name))
        else:
            dicc[vd.genre] = [(vd.rank, vd.name)]
    for key in dicc:
        dicc[key] = dicc[key][:n]
    return dicc


# def dibuja_ventas_por_zona(lista_juegos, anyo_inicial=None, anyo_final=None):
#     ventas = dicc_ventas_por_zona(lista_juegos, anyo_inicial, anyo_final)
#     lista_ventas = [v[1] for v in ventas.items()]
#     lista_zonas = [v[0] for v in ventas.items()]
#     titulo = 'Ventas por zona'
#     fig = plt.figure(titulo)
#     ax = fig.add_subplot(111)
#     n_x = range(len(lista_zonas))
#     ax.bar(n_x, lista_ventas, width=0.8, align='center')
#     ax.set_xticks(n_x)
#     ax.set_xticklabels(lista_zonas, rotation='vertical')
#     plt.show()


def distribuidora_mas_juegos_genero(lista_juegos, genero):
    dicc_conteo_distribuidora = Counter(vd.publisher for vd in lista_juegos if vd.genre == genero)  # Diccionario que asocia genero con cantidad
    # dicc_conteo_distribuidora = dict()
    # for vd in lista_juegos:
    #     if vd.genre == genero:
    #         if vd.publisher in dicc_conteo_distribuidora:
    #             dicc_conteo_distribuidora[vd.publisher] += 1
    #         else:
    #             dicc_conteo_generos[vd.publisher] = 1

    return max(dicc_conteo_distribuidora.items(), key=lambda x: x[1])[0]


def juegos_distinto_ranking_EU_NA(lista_juegos, n):
    mas_vendidos_eu = sorted(lista_juegos, key=lambda x: x.eu_sales, reverse=True)[:n]
    mas_vendidos_na = sorted(lista_juegos, key=lambda x: x.na_sales, reverse=True)[:n]
    return set(mas_vendidos_eu) ^ set(mas_vendidos_na)  # Diferencia simétrica: elementos que no se comparten entre A y B -> A^B


def juegos_mismo_ranking_EU_NA_JP(lista_juegos, n):
    mas_vendidos_eu = sorted(lista_juegos, key=lambda x: x.eu_sales, reverse=True)[:n]
    mas_vendidos_na = sorted(lista_juegos, key=lambda x: x.na_sales, reverse=True)[:n]
    mas_vendidos_jp = sorted(lista_juegos, key=lambda x: x.jp_sales, reverse=True)[:n]
    return set(mas_vendidos_eu) & set(mas_vendidos_na) & set(mas_vendidos_jp)  # Intersección: elementos que se comparten entre A y B -> A&B


def primer_juego_distinto(lista_juegos):
    mas_vendidos_eu = sorted(lista_juegos, key=lambda x: x.eu_sales, reverse=True)
    mas_vendidos_na = sorted(lista_juegos, key=lambda x: x.na_sales, reverse=True)
    for vd_eu, vd_na in zip(mas_vendidos_eu, mas_vendidos_na):
        if vd_eu != vd_na:
            return (vd_eu, vd_na)  # Devuelve el mayor al estar ordenado
