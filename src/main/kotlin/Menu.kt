class Menu {
    private val lanches = listOf(Item(1, "X-Burger", 10.00), Item(2, "X-Salada", 12.00))
    private val bebidas = listOf(Item(1, "Refrigerante", 8.00), Item(2, "Suco", 6.00))

    fun selecionarLanche(carrinho: Carrinho) {
        println("Selecione o lanche:")
        lanches.forEach { lanche -> println("${lanche.codigo}. ${lanche.nome}") }
        val opcaoLanche = lerInts()

        val lancheSelecionado = lanches.find { it.codigo == opcaoLanche }

        if (lancheSelecionado != null) {
            carrinho.adicionarItem(lancheSelecionado)
            println("Lanche adicionado ao carrinho!")
        } else {
            println("Opção inválida, tente novamente")
        }
        return
    }


    fun selecionarBebida(carrinho: Carrinho) {
        println("Selecione a bebida:")
        bebidas.forEach { bebida -> println("${bebida.codigo}. ${bebida.nome}") }
        val opcaoBebida = lerInts()

        val bebidaSelecionada = bebidas.find { it.codigo == opcaoBebida }

        if (bebidaSelecionada != null) {
            carrinho.adicionarItem(bebidaSelecionada)
            println("Bebida adicionada ao carrinho!")
        } else {
            println("Opção inválida, tente novamente")
        }
    }

    fun lerInts(): Int {
        var numero: Int
        while (true) {
            try {
                numero = readln().toInt()
            } catch (excecao: NumberFormatException) {
                println("Formato inválido, para escolher o item, você deve informar o número dele.")
                continue
            }
            return numero
        }
    }
}