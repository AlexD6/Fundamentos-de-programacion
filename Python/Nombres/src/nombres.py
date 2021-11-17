# -*- coding: utf-8 -*-
'''
Created on 16 dic. 2020

@author: alget
'''

import csv
from collections import namedtuple

FrecuenciaNombre = namedtuple('FrecuenciaNombre', 'anyo,nombre,frecuencia,genero')

def leer_frecuencias_nombres(fichero):
    '''
    ENTRADA: 
       - fichero: nombre del fichero de entrada -> str
       
    SALIDA: 
       - lista de tuplas (anyo,nombre,frecuencia,genero) -> [(int, str,int,str)]
    '''
    with open(fichero, encoding = 'utf-8') as f:
        lector = csv.reader(f)
        next(lector)
        registros = [FrecuenciaNombre(int(anyo), nombre, int(frecuencia), genero) for anyo, nombre, frecuencia, genero in lector]
    return registros

def filtrar_por_genero(registros, genero):
    '''
    ENTRADA: 
       - registros: lista de tuplas de tipo frecuenciaNombre
       - genero: genero a comprobar
       
    SALIDA: 
       - lista de tuplas (anyo,nombre,frecuencia,genero) -> [(int, str,int,str)]
    '''
    return (r for r in registros if r.genero == genero)
    
def calcular_nombres(registros, genero = None):
#     if genero is None:
#         return{r.nombre for r in registros}
#     else: 
#         return {r.nombre for r in filtrar_por_genero(registros, genero)}

    if genero is not None:
        registros = filtrar_por_genero(registros, genero)
    return set(r.nombre for r in registros)

def calcular_top_nombres_de_año(registros, anyo, limite = 10, genero = None):
    '''
    ENTRADA: 
       - registros: lista de tuplas de tipo frecuenciaNombre
       - anyo: el año a revisar -> int
       - limite: el limite de nombres a mostrar -> int
       - genero: genero a comprobar, puede ser hombre, mujer o none -> str(Default None
       
    SALIDA: 
       - Lista de tuplas (nombre,frecuencia) -> [(str,int)] con los nombres mas frecuentes
    '''
#     res = {}
#     for r in registros:
#         k = r.anyo
#         if genero == None:
#             if (r.anyo == anyo):
#                 if k not in res:
#                     res[k] = []
#                 if len(res[k]) < limite:
#                     res[k].append((r.nombre, r.frecuencia))
#         else:
#             if (r.anyo == anyo and r.genero == genero):
#                 if k not in res:
#                     res[k] = []
#                 if len(res[k]) < limite:
#                     res[k].append((r.nombre, r.frecuencia))
#     return sorted(res, reverse = True)

    if genero is not None:
        registros = filtrar_por_genero(registros, genero)
    res = [(r.nombre,r.frecuencia) for r in registros if r.anyo==anyo]
    res.sort(key=lambda x: x[1], reverse=True) #Mayor a menor
    return res[:limite]

def calcular_nombres_ambos_generos(registros):
    '''
    ENTRADA:
    - lista de registros FrecuenciaNombre
    
    SALIDA:
    - conjunto de nombres comunes a ambos géneros -> {str}
    '''
    nombres_hombres = calcular_nombres(registros, 'Hombre')
    nombres_mujeres = calcular_nombres(registros, 'Mujer')
    return nombres_hombres.intersection(nombres_mujeres)

def calcular_nombres_compuestos(registros, filtro=None):
    '''
    ENTRADA: 
    - lista de registros de tipo tupla FrecuenciaNombre
    - filtro: puede tomar los valores 'Hombre','Mujer' o None -> str

    SALIDA:
    - conjunto de nombres con más de una palabra -> {str}
    '''
    nombres = calcular_nombres(registros, filtro)
    return {n for n in nombres if ' ' in n}

def calcular_nombre_mas_frecuente_por_año(registros, genero = None):
    '''
    ENTRADA: 
    - lista de registros de tipo tupla FrecuenciaNombre
    - filtro: puede tomar los valores 'Hombre','Mujer' o None -> str

    SALIDA:
    - lista de tuplas con el nombre mas frecuente de cada año (año, nombre, frecuencia) -> (int, str, int)
    '''
#     if genero is not None:
#         registros = filtrar_por_genero(registros, genero)
#     res = [(r.anyo, r.nombre,r.frecuencia) for r in registros]
#     res.sort(key=lambda x: x[1], reverse=True) #Mayor a menor
#     return res[:1]    
    
    if genero is not None:
        registros = filtrar_por_genero(registros, genero)
    anyos = sorted(r.anyo for r in registros)
    res = []
    for a in anyos:
        registros_anyo = [r for r in registros if r.anyo == a]
        anyo, nombre, frecuencia, genero = max(registros_anyo, key = lambda r:r.frecuencia)
        tupla = (anyo, nombre, frecuencia)
        res.append(tupla)
    return set(res)