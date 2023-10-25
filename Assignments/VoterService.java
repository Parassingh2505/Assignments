package Assignments;

//VoterService class definition
public class VoterService {

// Method to create a Voter object based on name and age
public static Voter createVoter(String name, int age) {
   return new Voter(name, age);
}

// Method to get VoterType classification based on age criteria
public static VoterType getVoterDescription(Voter voter) {
   if (voter.getAge() >= 18) {
       return VoterType.VOTER_CAN_CAST_VOTE;
   } else if(voter.getAge() >= 0 && voter.getAge() < 18) {
       return VoterType.VOTER_CANNOT_CAST_VOTE;
   } else  {
       return VoterType.INVALID_VOTER;
   }
   }

public static void main(String[] args) {
    Voter voter1 = VoterService.createVoter("John Doe", 25);
    System.out.println("Voter 1: " + voter1);

    Voter voter2 = VoterService.createVoter("Alice Smith", 15);
    System.out.println("Voter 2: " + voter2);

    VoterType voter1Type = VoterService.getVoterDescription(voter1);
    System.out.println("Voter 1 is a " + voter1Type);

    VoterType voter2Type = VoterService.getVoterDescription(voter2);
    System.out.println("Voter 2 is a " + voter2Type);
}
}
