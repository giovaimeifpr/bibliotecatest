package br.edu.ifpr.biblioteca_spring;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifpr.biblioteca_spring.models.Livro;
import br.edu.ifpr.biblioteca_spring.service.LivroService;



@SpringBootTest
class BibliotecaSpringApplicationTests {
	
	private LivroService livroService;
    @BeforeEach
    void setUp() {
        livroService = new LivroService();
    }
    @AfterEach
    void tearDown() {
        livroService.limpar();
    }
    @Test
    void deveAdicionarLivroCorretamente() {
        Livro livro = livroService.adicionar("O Senhor dos Anéis", "J.R.R. Tolkien");
        assertNotNull(livro);
        assertEquals("O Senhor dos Anéis", livro.getTitulo());
        assertEquals("J.R.R. Tolkien", livro.getAutor());
    }

	@Test
    void deveListarApenasLivrosDisponiveis() {
		
		List<Livro> disponiveis = livroService.listarDisponiveis();
		assertNotNull(disponiveis);
		assertEquals(3, disponiveis.size());
		
    }
}
