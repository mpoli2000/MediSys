package com.medisys;

import java.util.ArrayList;

public interface IPacienteDAO {
    public void guardar(Paciente paciente);
    public void eliminar(int id_paciente);
    public Paciente buscar(int id_paciente);
    public ArrayList buscarTodos();









}
