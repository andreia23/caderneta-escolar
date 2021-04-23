package br.edu.ifpb.pweb2.bean;

import br.edu.ifpb.pweb2.controller.AlunoController;
import br.edu.ifpb.pweb2.model.Aluno;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Named(value = "notasListaBean")
@ViewScoped
public class NotasListaBean extends GenericAcademicoBean implements Serializable {

    private List<Aluno> alunos;

    @Inject
    private AlunoController controllerAluno;

    @PostConstruct
    public void init() {
        this.alunos = this.controllerAluno.findAll();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String formatarData(Date dt)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dt);
    }

    public String editar(Aluno a)
    {
        this.putFlash("editarAluno", a);
        return "/notas/editar?faces-redirect=true";
    }
}