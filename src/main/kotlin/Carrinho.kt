class Carrinho {
    val itens = mutableListOf<Item>()
    var valorTotal: Double = 0.00

    fun adicionarItem(item: Item) {
        val quantidade = validaQuantidade()
        val itemCopiado = Item(item)
        itemCopiado.quantidade = quantidade
        valorTotal += itemCopiado.preco * quantidade
        println("Item adicionado ao carrinho!")
        itens.add(itemCopiado)
    }

    fun mostrarCarrinho() {
        itens.forEachIndexed { index, item ->
            println(
                "${index + 1}. ${item.nome} \tPreço: R$%.2f \t\tQuantidade: ${item.quantidade} \t\tTotal: R$%.2f".format(
                    item.preco,
                    (item.preco * item.quantidade)
                )
            )
        }
        println("Total da compra: R$%.2f".format(valorTotal))
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

    fun editarItem() {
        while (true) {
            println("Digite o código do item que deseja editar:")
            val codigoItem = lerInts()
            val indice = codigoItem - 1


            if (indice in 0 until itens.size) {
                val item = itens[indice]

                val quantidade = validaQuantidade()

                valorTotal += item.preco * (quantidade - item.quantidade)
                item.quantidade = quantidade
                mostrarCarrinho()
                exibirOpcoesCarrinho()

            } else {
                println("Código inválido, tente novamente")
                continue
            }
            break
        }
    }

    fun removerItem() {
        while (true) {

            println("Digite o código do item que deseja remover:")
            val codigoItem = lerInts()
            val index = codigoItem - 1

            if (index in 0 until itens.size) {
                val item = itens.removeAt(index)
                valorTotal -= item.preco * item.quantidade
                mostrarCarrinho()
                exibirOpcoesCarrinho()
            } else {
                println("Código inválido, tente novamente")
                continue
            }
            break
        }
    }

    fun validaQuantidade(): Int {
        var quantidade: Int

        while (true) {
            println("Digite a quantidade:")
            try {
                quantidade = readln().toInt()
                if (quantidade <= 0) {
                    println("Quantidade inválida!")
                    continue
                }
            } catch (excecao: NumberFormatException) {
                println("Quantidade inválida!")
                continue
            }
            return quantidade
        }
    }


    fun exibirOpcoesCarrinho() {

        var opcao: Int

        do {
            println("1. Adicionar mais itens")
            println("2. Editar um item")
            println("3. Remover um item")
            println("4. Finalizar o pedido")
            println("5. Voltar para o menu principal")

            opcao = lerInts()

            when (opcao) {
                1 -> {
                    return
                }

                2 -> {
                    editarItem()
                    break
                }

                3 -> {
                    removerItem()
                    break
                }

                4 -> {
                    return
                }

                5 -> return
                else -> println("Opção inválida, tente novamente")
            }
        } while (true)
    }
}