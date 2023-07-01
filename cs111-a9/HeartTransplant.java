/**
 * 
 * HeartTransplant class
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {
        patients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {
        return patients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        patients = new Patient[numberOfLines];
        for(int i = 0; i < numberOfLines && StdIn.hasNextLine(); i++){
            int id = StdIn.readInt();
            int ethnicity = StdIn.readInt();
            int gender = StdIn.readInt();
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int stateOfHealth = StdIn.readInt();
            patients[i] = new Patient(id, ethnicity, gender, age, cause, urgency, stateOfHealth);
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge();
        for(int i = 0; i < numberOfLines && StdIn.hasNextLine(); i++){
            int age = StdIn.readInt();
            int years = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByAge.addData(age, years, rate);
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause();
        for(int i = 0; i < numberOfLines && StdIn.hasNextLine(); i++){
            int cause = StdIn.readInt();
            int years = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByCause.addData(cause, years, rate);
        }
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        int count = 0;  
        for(int i = 0; i < patients.length; i++){
            if(patients[i].getAge() > age){
                count++;
            }
        }
        Patient[] p = new Patient[count];
        for(int i = 0, j = 0; i < patients.length && j < count; i++){
            if(patients[i].getAge() > age){
                p[j] = patients[i];
                j++;
            }
        }
        if(count == 0){
            return null;
        }
        else{
            return p;
        }
    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {
        int count = 0;
        for(int i = 0; i < patients.length; i++){
            if(patients[i].getCause() == cause){
                count++;
            }
        }
        Patient[] p = new Patient[count];
        for(int i = 0, j = 0; i < patients.length && j < count; i++){
            if(patients[i].getCause() == cause){
                p[j] = patients[i];
                j++;
            }
        }
        if(count == 0){
            return null;
        }
        else{
            return p;
        }
    }

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {
        int count = 0;
        for(int i = 0; i < patients.length; i++){
            if(patients[i].getUrgency() == urgency){
                count++;
            }
        }
        Patient[] p = new Patient[count];
        for(int i = 0, j = 0; i < patients.length && j < count; i++){
            if(patients[i].getUrgency() == urgency){
                p[j] = patients[i];
                j++;
            }
        }
        if(count == 0){
            return null;
        }
        else{
            return p;
        }
    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 

     /*Among all patients who need a heart and with the highest urgency, 
    find the patient with the highest survivability rate in five years. 
    Then the target patient‘s needHeart should be marked as false and return the patient object.
    This survivability rate is calculated by finding the average of SurvivabilityByAge 
    and SurvivabilityByCause. 
    You can get the survivability by calling on non-static methods getRate(int age, int year) 
    and getRate(int cause, int year) in SurvivabilityByAge and SurvivabilityByCause
    Because the method marks the target patient’s needHeart to false, repetitive calls 
    on this method n times will give the top n patients with the highest survivability rate. */

    public Patient getPatientForTransplant () {
        Patient p[] = getPatients();
        survivabilityByAge = getSurvivabilityByAge();
        survivabilityByCause = getSurvivabilityByCause();
        int urgency = 0;
        int person = 0;
        double rate = 0;
        double highestRate = 0;
        for(int i = 0; i < patients.length; i++){
            if(p[i].getNeedHeart()){
                if(p[i].getUrgency() > urgency){
                    urgency = p[i].getUrgency();
                    rate = (survivabilityByAge.getRate(p[i].getAge(), 5) + survivabilityByCause.getRate(p[i].getCause(), 5)) / 2;
                    if(rate > highestRate){
                        highestRate = rate;
                        person = i;
                    }
                }   
            }
        }
        p[person].setNeedHeart(false);
        return p[person];
    }
}
