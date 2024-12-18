package projeto.banco.model;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
	private String cpf;
	private String nome;
	
	private ArrayList<Conta> contas;
	
	public Cliente() {
		
	}
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		contas = new ArrayList<>();
	}
	
	public void adicionarConta(Conta novaConta) {
		if(contas.contains(novaConta)) {
			System.out.println("Conta já cadastrada");
		} else {
			System.out.println("Conta cadastrada com sucesso");
		}
	}
	
	public void removerConta(Conta velhaConta) {
		if(contas.contains(velhaConta)) {
			contas.remove(velhaConta);
			System.out.println("Conta removida com sucesso!");
		} else {
			System.out.println("Conta nao localizada");
		}
	}
	
	public Conta localizarContaPorNumero(Integer numero) {
		Conta temp = new Conta(numero);
		
		if(contas.contains(temp)) {
			int index = contas.indexOf(temp);
			temp = contas.get(index);
			return temp;
		}
		return null;
	}
	
	public void atualizarConta(Conta contaAntiga) {
		if(contas.contains(contaAntiga)) {
			int index = contas.indexOf(contaAntiga);
			contas.set(index, contaAntiga);
			System.out.println("Conta atualizada com sucesso");
		}else
			System.out.println("Conta n�o localizada");
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contas=" + contas + "]";
	}
}
