# -*- coding: utf-8 -*-
'''
Created on 11 nov. 2020

@author: alegestor

'''

import csv
from collections import namedtuple
from datetime import datetime
# from matplotlib import pylab as plt

Registro = namedtuple('Registro', 'fecha, local, visitante,shot_number,period,game_clock,dribbles,shot_dist,pts_type,closest_defender,pts,player_name')

########################################################################################

def lee_NBA(fichero):
    ''' Lee el fichero de entrada y devuelve una lista de tuplas poblaciones
    
    ENTRADA: 
       - fichero: nombre del fichero de entrada -> str
       
    SALIDA: 
       - lista de tuplas (fecha, local, visitante,shot_number,period,game_clock,dribbles,shot_dist,pts_type,closest_defender,pts,player_name) -> [(datetime, str, str, int, int,str,int,int,int,str,int,str)]
    '''
    registros = []
    with open(fichero, encoding = "utf-8") as f:
        lector = csv.reader(f)
        next(lector)     
        for matchup,shot_number,period,game_clock,dribbles,shot_dist,pts_type,closest_defender,pts,player_name in lector:
            fecha, equipos = matchup.split(" - ")
            local, visitante = equipos.split(" @ ")
            registros.append(Registro(datetime.strptime(fecha, '%b %d. %Y').date(), local, visitante,int(shot_number),int(period),game_clock,int(dribbles),int(shot_dist),int(pts_type),closest_defender,int(pts),player_name))
    return registros

def enfrentamientos_jugadores_1(registros, atacante):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros
       - Nombre del jugador atacante
       
    SALIDA: 
       - Lista de tuplas (pts_type, pts, closest_defender) 
    '''
    return [(r.pts_type, r.pts, r.closest_defender) for r in registros if r.player_name == atacante]

def anotaciones_por_jugador_3(registros, nombre):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros
       - Nombre del jugador del cual se quiere hacer la consulta
       
    SALIDA: 
       - El numero de puntos anotados por dicho jugador (int)
    '''
    return sum(r.pts for r in registros if r.player_name == nombre)

def maximo_anotador_4(registros):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros
       
    SALIDA: 
       - Tupla con el maximo anotador y el numero de puntos anotados por dicho jugador (str,int)
    '''
    anotadores = {r.player_name for r in registros}
    pts_por_anotador = [(anotaciones_por_jugador_3(registros, a),a) for a in anotadores]
    return max(pts_por_anotador)

def anotadores_por_equipo_6(registros, equipo):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros
       - Nombre del equipo del cual se quiere hacer la consulta

    SALIDA: 
       - Tupla ordenada de mayor a menor con el numero de puntos anotados y el anotador en cuestion (int,str)
    '''
    anotadores_equipo = {r.player_name for r in registros if r.local == equipo}
    res = [(anotaciones_por_jugador_3(registros, a),a) for a in anotadores_equipo]
    return sorted(res, reverse = True)

def jugadores_por_equipo_7(registros):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros

    SALIDA: 
       - Diccionario con todos los equipos y sus jugadores en plantilla
    '''
    dicc = {}
    for r in registros:
        k = r.local
        if (k not in dicc):
            dicc[k] = set([r.player_name])
        else:
            dicc[k].add(r.player_name)
    return dicc

def contar_jugadores_por_equipo_8(registros):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros

    SALIDA: 
       - Diccionario con todos los equipos y el numero de jugadores en plantilla
    '''
    dicc = jugadores_por_equipo_7(registros)
    for d in dicc:
        dicc[d] = len(dicc[d])
    return dicc

def equipo_con_mas_jugadores_11(registros):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros

    SALIDA: 
       - Tupla con el equipo con mas jugadores y su numero
    '''
    dicc = contar_jugadores_por_equipo_8(registros)
    return sorted(dicc.items(), key = lambda x: x[1], reverse = True)[:1]
        
def tiro_mas_lejano_y_resultado_12(registros):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros

    SALIDA: 
       - Diccionario con el tiro mas lejano de cada jugador y su resultado
    '''
    dicc = {}
    for r in registros:
        k = r.player_name
        if k in dicc:
            if r.shot_dist > dicc[k][0]:
                dicc[k] = (r.shot_dist, r.pts)
        else:
            dicc[k] = (r.shot_dist, r.pts)
    return dicc

def top_n_dribbles_por_jugador_14(registros, n = 3):
    '''
    ENTRADA: 
       - Lista de tiros de campo: lista de tuplas Registros
       - Integer n datos que se desea mostrar. De forma predeterminada es 3

    SALIDA: 
       - Diccionario con todos los jugadores y su top n numero de dribbles antes de tirar 
    '''
    dicc = {}
    for r in registros:
        k = r.player_name
        if k in dicc:
            dicc[k].append(r.dribbles)
        else:
            dicc[k] = [r.dribbles]
    for key in dicc:
        dicc[key] = sorted(dicc[key], reverse = True)[:n]  
    return dicc

 def grafica_anotaciones_por_jugador_16(registros):
     '''
     ENTRADA: 
        - Lista de tiros de campo: lista de tuplas Registros
  
     SALIDA: 
        - Grafica con las anotaciones de cada jugador 
     '''
     dicc = {}
     for r in registros:
         k = r.player_name
         if k in dicc:
             dicc[k] += r.pts
         else:
             dicc[k] = r.pts
     titulo = 'Grafica de anotaciones por jugador'
     fig = plt.figure(titulo)
     jugadores, puntos = zip(*sorted(dicc.items()))
     ax = fig.add_subplot(111)
     n_x = range(len(jugadores))
     ax.bar(n_x, puntos, width=0.8, align='center')
     ax.set_xticks(n_x)
     ax.set_xticklabels(jugadores, rotation='vertical')
     plt.show()    