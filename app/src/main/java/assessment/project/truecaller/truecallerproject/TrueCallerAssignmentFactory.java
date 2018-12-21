package assessment.project.truecaller.truecallerproject;

public class TrueCallerAssignmentFactory {

    public Object getDataStructureType(String problemStatement,String response){
        if(problemStatement == null){
            return null;
        }
        if(problemStatement.equalsIgnoreCase("find10thChar")){
            return new Find10thCharacter(response);

        } else if(problemStatement.equalsIgnoreCase("every10thChar")){
            return new Every10thCharacter(response);

        } else if(problemStatement.equalsIgnoreCase("wordsCount")){
            return new WordsCount(response);
        }

        return null;
    }
}
