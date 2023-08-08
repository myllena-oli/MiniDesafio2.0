import kotlin.NumberFormatException

class FastFood {
    private val menu = Menu()
    private val carrinho = Carrinho()
    private val pagamento = Pagamento()

    fun iniciar() {
        println("\nBem-Vindo!\n")
        while (true) {
            println("Selecione o que deseja comprar:")
            println("1. Lanche")
            println("2. Bebida")
            println("3. Finalizar Compra")

            when (lerInts()) {
                1 -> {
                    menu.selecionarLanche(carrinho)
                    carrinho.mostrarCarrinho()
                    carrinho.exibirOpcoesCarrinho()
                }

                2 -> {
                    menu.selecionarBebida(carrinho)
                    carrinho.mostrarCarrinho()
                    carrinho.exibirOpcoesCarrinho()
                }

                3 -> {
                    pagamento.finalizarPedido(carrinho)
                    break
                }

                else -> println("Opção inválida, tente novamente")
            }
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