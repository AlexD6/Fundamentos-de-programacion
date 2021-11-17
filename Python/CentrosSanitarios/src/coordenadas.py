# -*- coding: utf-8 -*-
'''
Created on 18 nov. 2020

@author: alegestor
'''
from collections import namedtuple
import math

Coordenada = namedtuple('Coordenada', 'latitud, longitud')

########################################################################################

def calcular_distancia(coord1, coord2):
    '''
    ENTRADA: 
       - coord1: Tupla coordenada (float, float)
       - coord2: Tupla coordenada (float, float)
       
    SALIDA: 
       - distancia: float
    '''    
    x = coord2.latitud  - coord1.latitud
    y = coord2.longitud - coord1.longitud
    return math.sqrt(x**2 + y**2)

def calcular_media_coordenadas(coordenadas):
    '''
    ENTRADA: 
       - Lista de coordenadas: lista de tuplas Coordenada(float, float)
       
    SALIDA: 
       - Media: tupla coordenada(float,float)
    '''
    x = sum(c.latitud for c in coordenadas)/len(coordenadas)
    y = sum(c.longitud for c in coordenadas)/len(coordenadas)
    return Coordenada(x,y)