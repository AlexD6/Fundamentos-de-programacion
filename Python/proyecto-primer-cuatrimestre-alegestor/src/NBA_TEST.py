# -*- coding: utf-8 -*-
'''
Created on 11 nov. 2020

@author: alegestor
'''
from NBA import *

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
def test_lee_NBA():
    print("Leidos" , len (NBA_Shots), "datos de los tiros de la NBA en 2014")
    mostrar_numerado(NBA_Shots[:5])

def test_enfrentamientos_jugadores_1(atacante):
    res = enfrentamientos_jugadores_1(NBA_Shots, atacante)
    print("La lista de intentos de anotacion del jugador {} es (El primer numero es el tipo de punto y el segundo es si lo consigue o no): \n {}".format(atacante, res))
  
def test_anotaciones_por_jugador_3(nombre):
    res = anotaciones_por_jugador_3(NBA_Shots, nombre)
    print("Los puntos anotados por {} son {}".format(nombre, res))
    
def test_maximo_anotador_4():
    puntos, anotador = maximo_anotador_4(NBA_Shots)
    print("El maximo anotador de la temporada es {} con {} puntos".format(anotador, puntos))

def test_anotadores_por_equipo_6(equipo):
    res = anotadores_por_equipo_6(NBA_Shots, equipo)
    print("Los anotadores de {} son: \n {}".format(equipo,res))

def test_jugadores_por_equipo_7():
    res = jugadores_por_equipo_7(NBA_Shots)
    print("Los jugadores por equipo son: {} \n".format(res))      
    
def test_contar_jugadores_por_equipo_8():
    res = contar_jugadores_por_equipo_8(NBA_Shots);
    print("El numero de jugadores que tiene cada equipo es: {} \n".format(res));
    
def test_equipo_con_mas_jugadores_11():
    res = equipo_con_mas_jugadores_11(NBA_Shots)
    print("El equipo con mas jugadores y su numero es: {} ".format(res))
    
def test_tiro_mas_lejano_y_resultado_12(equipo):
    res = tiro_mas_lejano_y_resultado_12(NBA_Shots, equipo)
    print("El tiro mas lejano de cada jugador y su resultado: \n{} ".format(res))
    
def test_top_n_dribbles_por_jugador_14(n):
    res = top_n_dribbles_por_jugador_14(NBA_Shots,n)
    print("El top {} dribbles antes de tirar de cada jugador: \n{}".format(n, res))
    
def test_grafica_anotaciones_por_jugador_16():
    res = grafica_anotaciones_por_jugador_16(NBA_Shots)
    print(res)
################################################################
#  Programa principal
################################################################
if __name__ == '__main__':
    NBA_Shots = lee_NBA('../data/NBA_Shots.csv')
    
    nombre = 'dwayne wade'
    atacante = 'dwayne wade'
    equipo = 'GSW'
    n = 2
    
    test_lee_NBA()
    test_enfrentamientos_jugadores_1(atacante)
    test_anotaciones_por_jugador_3(nombre)
    test_maximo_anotador_4()
    test_anotadores_por_equipo_6(equipo)
    test_jugadores_por_equipo_7()
    test_contar_jugadores_por_equipo_8()
    test_equipo_con_mas_jugadores_11()
    test_tiro_mas_lejano_y_resultado_12(equipo)
    test_top_n_dribbles_por_jugador_14(n)
    test_grafica_anotaciones_por_jugador_16()