package com.example.academia.Model


class Categoria(

        var titulo: String = "",
        var treinos: MutableList<Treino> = ArrayList()
)

class Treino(

        var treino: Int = 0
)