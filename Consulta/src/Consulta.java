public class Consulta {

    private String nome;
    private String cpf;
    private String telefone;
    private String data;
    private boolean paciente;
    private boolean realizada;
    private String observacoes;

    public Consulta(String nome, String cpf, String telefone,
                    String data, boolean paciente) {

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data = data;
        this.paciente = paciente;

        this.realizada = false;
        this.observacoes = "";
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getData() {
        return data;
    }

    public boolean isPaciente() {
        return paciente;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}