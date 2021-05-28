package sample.logic.services;

import sample.logic.entities.*;

public interface IReportServices {

    public Map<String, Report> getReportPersonasByProfession();
    public Map<String, Report> getReportPersonasByProfession(List<Persona> personas);

    public Report getCountOfVictims();

}