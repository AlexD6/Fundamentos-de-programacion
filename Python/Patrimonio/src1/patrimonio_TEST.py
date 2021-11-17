# -*- coding: utf-8 -*-
'''
Created on 13 ene. 2021

@author: alget
'''
from patrimonio import *

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
def test_lee_Bienes():
    print("Leidos" , len (Bienes), "datos de la WHS")
    mostrar_numerado(Bienes[:5])
    
def test_calcula_paises():
    res = calcula_paises(Bienes)
    print(res)

def test_bienes_por_tipo():
    res = bienes_por_tipo(Bienes)
    print(res)

def test_dibuja_bienes_por_tipo():
    res = dibuja_bienes_por_tipo(Bienes)
    print(res)
    
def test_pais_mas_bienes():
    res = pais_mas_bienes(Bienes)
    print(res)
################################################################
#  Programa principal
################################################################
if __name__ == '__main__':
    Bienes = lee_bienes('../data/whs.csv')
    
#     test_lee_Bienes()
#     test_calcula_paises()
#     test_bienes_por_tipo()
#     test_dibuja_bienes_por_tipo()
    test_pais_mas_bienes()
