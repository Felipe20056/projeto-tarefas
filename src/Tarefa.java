import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private String descricao;
    private boolean concluida;
    private Prioridade prioridade;
    private LocalDateTime dataCriacao;


    public Tarefa(String descricao, Prioridade prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = false;
        this.dataCriacao = LocalDateTime.now();
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }



    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String status = concluida ? "[CONCLUÍDA]" : "[PENDENTE]";
        return status + " | Prioridade: " + prioridade + " | " + descricao + " (Criado em: " + dataCriacao.format(fmt) + ")";
    }
}