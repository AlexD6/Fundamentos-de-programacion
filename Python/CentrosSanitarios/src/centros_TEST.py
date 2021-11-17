# -*- coding: utf-8 -*-
'''
Created on 18 nov. 2020

@author: alegestor
'''
from centros import *

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
def test_lee_centroSanitario():
    print("Leidos" , len (LECTOR), "centros sanitarios")
    mostrar_numerado(LECTOR[:5])

################################################################
#  Programa principal
################################################################
if __name__ == '__main__':
    LECTOR = lee_centroSanitario('../data/centrosSanitarios.csv')
        
    test_lee_centroSanitario()