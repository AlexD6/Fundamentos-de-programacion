# -*- coding: utf-8 -*-
'''
Created on 16 dic. 2020

@author: alget
'''

from nombres import *

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
def test_leer_frecuencias_nombres():
    print("Leidos" , len (nombres), "datos de los nombres")
    mostrar_numerado(nombres[:5])
    
def test_calcular_top_nombres_de_año(anyo, limite = 10, genero = None):
    res = calcular_top_nombres_de_año(nombres, anyo, limite, genero)
    print("el top {} nombres_de_año {}: \n {}".format(limite, anyo, res))
    
################################################################
#  Programa principal
################################################################
if __name__ == '__main__':
    nombres = leer_frecuencias_nombres('../data/frecuencias_nombres.csv')
    
#     test_leer_frecuencias_nombres()
    test_calcular_top_nombres_de_año(2002)