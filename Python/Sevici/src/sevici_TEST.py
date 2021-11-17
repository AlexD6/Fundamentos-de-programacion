# -*- coding: utf-8 -*-
'''
Created on 4 nov. 2020

@author: alegestor
'''
from sevici import *

################################################################
#  Funciones auxiliares
################################################################
def mostrar_numerado(coleccion):
    i=0
    for p in coleccion:
        i=i+1
        print (i, p) 
################################################################
#  Funciones de test
################################################################
def test_lee_estaciones():
    print(estaciones[:5])

def test_estaciones_bicis_libres():
    print(estaciones_bicis_libres(estaciones))

################################################################
#  Programa principal
################################################################
if __name__ == '__main__':
    estaciones = lee_estaciones('../data/estaciones.csv')
        
    test_lee_estaciones()
    test_estaciones_bicis_libres()
