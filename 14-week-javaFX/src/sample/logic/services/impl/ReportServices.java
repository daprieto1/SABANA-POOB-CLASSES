package sample.logic.services.impl;

import sample.logic.entities.*;

public class ReportServices implements IReportServices {

    private IPersonasService personasService;

    public ReportServices {
        personasService = new PersonasService();
    }

    public Map<String, Report> getReportPersonasByProfession() {

        List<Persona> personas = personasService.getAll();
        this.getReportPersonasByProfession(personas);
    }

    public Map<String, Report> getReportPersonasByProfession(List<Persona> personas) {

        Map<String, Report> reports = new HashMap();

        for (ProfessionalEnum profession : ProfessionalEnum.getValues()) {
            reports.put(profession.toString(), new Report(profession.toString(), 0, String.format("Report of count of personas in profession %s", profession.toString())))
        }

        for (Persona p : personas) {
            reports.get(p.getProfession().getString()).incrementCount();
        }


        return reports;

    }

    public Report getCountOfVictims() {

        List<Persona> personas = personasService.getAll();
        int numOfVictims = personas.stream().filter(p -> p.isVictim()).count();

        return new Report("Victims", numOfVictims, "This is the number of victims during the strikes");
    }

}