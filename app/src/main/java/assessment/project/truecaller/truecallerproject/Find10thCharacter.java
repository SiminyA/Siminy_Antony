package assessment.project.truecaller.truecallerproject;

public class Find10thCharacter implements TrueCallerFactoryInterface {

    private String dataResponse;

    public Find10thCharacter(String response){
        this.dataResponse = response;
    }

    public StringBuilder getData() {
        StringBuilder tengthChar = new StringBuilder("Character on 10th position on response :: ");
        if (dataResponse != null) {
            tengthChar.append(dataResponse.charAt(9));
        }
        return tengthChar;
    }
}