package query;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class JenaCommons {

    public static ResultSet runQuery(String sparqlQuery) throws Exception {
        Model model = ModelFactory.createDefaultModel();
        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);

        ResultSet results = queryExecution.execSelect();
        return results;
    }
}