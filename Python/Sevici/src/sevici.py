# -*- coding: utf-8 -*-
'''
Created on 4 nov. 2020

@author: alegestor
'''
import csv
from collections import namedtuple

from src.coordenadas import *

Sevici = namedtuple('Sevici', 'name,slots,empty_slots,free_bikes,coordenada')

estaciones = []
def lee_estaciones(fichero):
    with open(fichero, encoding = "utf-8") as f:
        lector = csv.reader(f)
        next(lector)
        estaciones = [Sevici(name,int(slots),int(empty_slots),int(free_bikes),Coordenada(latitud, longitud)) for name,slots,empty_slots,free_bikes,latitud, longitud in lector]
    return estaciones

def estaciones_bicis_libres(estaciones, k = 5):
    res = [(e.name, e.free_bikes) for e in estaciones if e.free_bikes >= k]
    return sorted(res)