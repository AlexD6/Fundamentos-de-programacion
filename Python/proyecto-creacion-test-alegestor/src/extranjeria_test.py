# -*- coding: utf-8 -*-
'''
Created on 21 oct. 2020

@author: alegestor
'''

from extranjeria import *
from builtins import set

#####################
##FUNCIONES DE TEST##
#####################

def test_numero_nacionalidades_distintas(registros):
    print("TEST de numero_nacionalidades_distintas:")
    res = numero_nacionalidades_distintas(registros)
    print("    - Numero de nacionalidades: {}\n".format(res))
    
def test_secciones_distritos_con_extranjeros_nacionalidades(registros):
    print("TEST de secciones_distritos_con_extranjeros_nacionalidades:")
    paises1 = set(["ALEMANIA","CHINA"])
    res1 = secciones_distritos_con_extranjeros_nacionalidades(registros, paises1)
    print("    - Paises{}: {}\n".format(paises1,res1))
    
def test_total_extranjeros_por_pais(registros):
    print("TEST de total_extranjeros_por_pais:")
    res = total_extranjeros_por_pais(registros)
    print("    - Total de extrajeros por pais: {}\n".format(res))
    
def test_top_n_extranjeria(registros, n):
    print("TEST de top_n_extranjeria:")
    res = top_n_extranjeria(registros, n=5)
    print("    - Top {} de extranjeria: {}\n".format(n, res))
    
def test_barrio_con_mas_extranjeros(registros):
    print("TEST de barrio_con_mas_extranjeros:")
    tipo1 = set(["HOMBRES"])
    res1 = barrio_con_mas_extranjeros(registros, tipo1)
    print("    - Barrio con mas extranjeros de genero {}: {}\n".format(tipo1,res1))
    
def test_pais_mas_representado_por_distrito(registros): 
    print("TEST de pais_mas_representado_por_distrito:")
    res = pais_mas_representado_por_distrito(registros)
    print("    - Pais mas representado por distrito: {}\n".format(res))
    
######################
##PROGRAMA PRINCIPAL##
######################

registros = lee_datos_extranjeros("../data/extranjerosSevillla.csv")
print(registros[:5])

# test_numero_nacionalidades_distintas(registros)
# test_secciones_distritos_con_extranjeros_nacionalidades(registros)
# test_total_extranjeros_por_pais(registros)
# test_top_n_extranjeria(registros, n=5)
# test_barrio_con_mas_extranjeros(registros)
# test_pais_mas_representado_por_distrito(registros)