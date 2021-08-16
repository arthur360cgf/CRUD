package contatos;
import java.util.List;


public class Pessoa {
	private String nome;
    private String CPF;
    private List<Telefone> telefones;

    
    
    public Pessoa(String nome,String CPF) {
    	this.nome = nome;
    	this.CPF = CPF;
    	
    	
    	
    }
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public void setCpf(String CPF) {
    	this.CPF = CPF;
    }
    
    public String getCpf() {
    	return CPF;
    }
    
}
