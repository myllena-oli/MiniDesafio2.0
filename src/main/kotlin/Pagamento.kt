class Pagamento {
    fun finalizarPedido(carrinho: Carrinho) {
        carrinho.mostrarCarrinho()

        println("Escolha a forma de pagamento:")
        println("1. Cartão de Crédito")
        println("2. Cartão de Débito")
        println("3. Vale Refeição")
        println("4. Dinheiro")
        println("5. Desistir da compra")

        when (lerInt()) {
            1, 2, 3 -> println("Compra finalizada com sucesso! Boa refeição.")
            4 -> pagarEmDinheiro(carrinho)
            5 -> return
            else -> println("Opção inválida, tente novamente")
        }

        println("Retire o seu pedido no balcão!")

    }

    private fun pagarEmDinheiro(carrinho: Carrinho) {
        println("Digite o valor em dinheiro:")
        val dinheiro = lerDouble()

        if (dinheiro >= carrinho.valorTotal) {
            val troco = dinheiro - carrinho.valorTotal
            println("Compra finalizada com sucesso! Troco: R$%.2f".format(troco))
        } else {
            println("Valor insuficiente. Insira um valor maior ou igual ao total da compra.")
        }
    }

    private fun lerInt(): Int {
        var numero: Int
        while (true) {
            try {
                numero = readln().toInt()
            } catch (excecao: NumberFormatException) {
                println("Formato inválido, digite novamente.")
                continue
            }
            return numero
        }
    }

    private fun lerDouble(): Double {
        var numero: Double
        while (true) {
            try {
                numero = readln().toDouble()
            } catch (excecao: NumberFormatException) {
                println("Formato inválido, digite novamente.")
                continue
            }
            return numero
        }
    }
}