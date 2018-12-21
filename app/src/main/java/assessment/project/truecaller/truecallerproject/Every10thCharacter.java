package assessment.project.truecaller.truecallerproject;

public class Every10thCharacter implements TrueCallerFactoryInterface {

    private String dataResponse;

    public Every10thCharacter(String response){
        this.dataResponse = response;
    }

    @Override
    public StringBuilder getData() {
        StringBuilder every10thCharacter = new StringBuilder();
        for (int i = 9; i < dataResponse.length(); i = i + 10) {
            every10thCharacter.append(dataResponse.charAt(i));
        }
        return every10thCharacter;
    }
}