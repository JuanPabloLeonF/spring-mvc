package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    CLIArguments(){

    }
    @Parameter(required = true, descriptionKey = "KEYWORD", description = "KEYWORD", validateWith = CLIKeywordValidator.class)
    private String keyword;
    @Parameter(names = {"--location", "-lg"}, description = "Cada busqueda puede incluir una ubicacion")
    private String location;
    @Parameter(names = {"--page", "-p"}, description = "La API devuelve 50resultados, usa un numero para la pagina")
    private Integer page = 0;
    @Parameter(names = {"--full-time"}, description = "Agregar si queremos trabajos de tiempo completo")
    private Boolean isFullTime = false;
    @Parameter(names = {"--markdown"}, description = "Obtener los resultados en markdown")
    private Boolean isMarkdown = false;
    @Parameter(names = "--help", help = true, description = "Mostrar esta ayuda", validateWith = CLIHelpValidator.class)
    private Boolean isHelp;

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public Integer getPage() {
        return page;
    }

    public Boolean getFullTime() {
        return isFullTime;
    }

    public Boolean getMarkdown() {
        return isMarkdown;
    }

    public Boolean getHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
