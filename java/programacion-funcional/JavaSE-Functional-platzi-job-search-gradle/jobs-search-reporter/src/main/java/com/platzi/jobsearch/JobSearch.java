package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.IApiJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunction.buiildCommanderWithName;
import static com.platzi.jobsearch.CommanderFunction.parseArguments;
import static com.platzi.jobsearch.api.IApiFunction.buildApi;

public class JobSearch {
    public static void main(String[] args) {
        JCommander jCommander = buiildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream().map(object -> (CLIArguments) object);

        Optional<CLIArguments> cliArgumentsOptional = streamOfCLI
                .filter(cli -> !cli.getHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap).map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        IApiJobs iApiJobs = buildApi(IApiJobs.class, "https://jobs.github.com");

        return Stream.of(params)
                .map(iApiJobs::jobs)
                .flatMap(Collection::stream);
    }
}