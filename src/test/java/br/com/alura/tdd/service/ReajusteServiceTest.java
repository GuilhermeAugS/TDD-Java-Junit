package br.com.alura.tdd.service;
import org.junit.jupiter.api.*;
import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("1000"));
		System.out.println("Iniciado!");
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Finalizado!");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.print("Antes de todos");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.print("Depois de todos");
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
		
		service.concederReajuste(funcionario, Desempenho.BOM);	
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeVinteECincoPorCentoQuandoDesempenhoForOtimo() {
		
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1250.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuarentaPorCentoQuandoDesempenhoForOtimo() {

		service.concederReajuste(funcionario, Desempenho.ESPETACULAR);
		assertEquals(new BigDecimal("1400.00"), funcionario.getSalario());
	}

}
