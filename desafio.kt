enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario (
    val nome : String,
    val id: Int,
    var email: String
)

data class ConteudoEducacional(
    val nome: String,
    var duracao: Int = 0
)

data class Formacao(
    val nome: String,
    var conteudos: List<ConteudoEducacional>,
    var nivel : Nivel

){
    val inscritos = mutableListOf<Usuario>()

    infix fun matricular(usuario: Usuario) {
        inscritos.add(usuario) 
    }

    fun matricular(vararg usuarios: Usuario){
        for(usuario in usuarios)
            inscritos.add(usuario)
    }
    
    // Funcaes que mostram Usuarios e Conteudos cadastrados
    fun mostrarUsuariosInscritos(){
        for(usuariosInscritos in inscritos){
            println(usuariosInscritos.nome)
        }
    }
    fun mostrarConteudos(){
        for(conteudo in conteudos)
            println(conteudo.nome)
    }
}

fun main() {
    // Criar novo usuario 
    val user1 = Usuario("Everton",1,"iton.antunes@gmail.com")
    val user2 = Usuario("Carlos",2,"carlos.exemplo@gmail.com")
    val user3 = Usuario("Roberto",3,"roberto.exemplo@gmail.com")
    
    // Criar conteudo educacional
    val kotlinExperience : List<ConteudoEducacional> = listOf(
        ConteudoEducacional(" * Introdução ao Desenvolvimento de Software", 5),
        ConteudoEducacional(" * Documentação oficial do Kotlin", 15),
        ConteudoEducacional(" * Orientação a objetos e classes", 10),
        ConteudoEducacional(" * Desafio de Codigo", 5)
    )
    
    val formacaoKotlin = Formacao ("Kotlin Experience",kotlinExperience,Nivel.BASICO)
    
    
    println("| °  Formação: ${formacaoKotlin.nome}  ° | \n\tNivel: ${formacaoKotlin.nivel}\n")
    println("Grade do Curso: \n")
    
    
    formacaoKotlin.mostrarConteudos()
    formacaoKotlin.matricular(user1)
    println("\n")
    println("| °  Processo de matriculas  ° |")
    println("\n")
    println("O aluno ${user1.nome} foi matriculado no curso ${formacaoKotlin.nome} com sucesso !")
    formacaoKotlin.matricular(user2)
    println("O aluno ${user2.nome} foi matriculado no curso ${formacaoKotlin.nome} com sucesso !")
    formacaoKotlin.matricular(user3)
    println("O aluno ${user3.nome} foi matriculado no curso ${formacaoKotlin.nome} com sucesso !")
  
    
    println("\n")
    println("Alunos Matriculados no Curso: ${formacaoKotlin.nome}\n")
    formacaoKotlin.mostrarUsuariosInscritos()
    println("\n")
    println("| ° -------------------------- ° |")
    
}
