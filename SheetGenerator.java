import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class SheetGenerator {
    private static int strength = 0;
    private static int dexterity = 0;
    private static int constitution = 0;
    private static int intelligence = 0;
    private static int wisdom = 0;
    private static int charisma = 0;

    public static void main(String[] args){
        int baseHealth = 0;
        int baseAttackBonusMelee = 0;
        int baseAttackBonusRanged = 0;
        int skillRanks = 0;
        int fortSave = 0;
        int refSave = 0;
        int willSave = 0;
        String playerClass = "I TOLD YOU NOT TO TRY TO BREAK IT";
        String race = "I TOLD YOU NOT TO TRY TO BREAK IT";
        int AC = 0;
        int initiative = 0;

        System.out.println("=========================");
        System.out.println("Welcome to my Technically not Randomized Automatic Sheet Helper, or TRASH!");
        System.out.println("TRASH is designed to provide a basic--not optimal--semi-randomized sheet for those new to the roleplaying game Pathfinder.");
        System.out.println("Technical notes: This creates a level 1 character where attributes are determined by a 4d6d1 system, where four six-sided dice are rolled and the lowest is dropped.");
        System.out.println("=========================");
        System.out.println("You have a few options as far as races go. There are more races, but they typically aren't suited for new players. Please input the number at the beginning of their description to select it.");
        System.out.println("1: Dwarf: These short and stocky defenders of mountain fortresses are often seen as stern and humorless. Known for mining the earth’s treasures and crafting magnificent items from ore and gemstones, they have an unrivaled affinity for the bounties of the deep earth. Dwarves also have a tendency toward traditionalism and isolation that sometimes manifests as xenophobia.");
        System.out.println("2: Elf: Elf: Tall, noble, and often haughty, elves are long-lived and subtle masters of the wilderness. Elves excel in the arcane arts. Often they use their intrinsic link to nature to forge new spells and create wondrous items that, like their creators, seem nearly impervious to the ravages of time. A private and often introverted race, elves can give the impression they are indifferent to the plights of others.");
        System.out.println("3: Gnome: Expatriates of the strange land of fey, these small folk have a reputation for flighty and eccentric behavior. Many gnomes are whimsical artisans and tinkers, creating strange devices powered by magic, alchemy, and their quirky imagination. Gnomes have an insatiable need for new experiences that often gets them in trouble.");
        System.out.println("4: Half Elf: Often caught between the worlds of their progenitor races, half-elves are a race of both grace and contradiction. Their dual heritage and natural gifts often create brilliant diplomats and peacemakers, but half-elves are often susceptible to an intense and even melancholic isolation, realizing that they are never truly part of elven or human society.");
        System.out.println("5: Half Orc: Often fierce and savage, sometimes noble and resolute, half-orcs can manifest the best and worst qualities of their parent races. Many half-orcs struggle to keep their more bestial natures in check in order to epitomize the most heroic values of humanity. Unfortunately, many outsiders see half-orcs as hopeless abominations devoid of civility, if not monsters unworthy of pity or parley.");
        System.out.println("6: Halfling: Members of this diminutive race find strength in family, community, and their own innate and seemingly inexhaustible luck. While their fierce curiosity is sometimes at odds with their intrinsic common sense, half lings are eternal optimists and cunning opportunists with an incredible knack for getting out the worst situations.");
        System.out.println("7: Human: Ambitious, sometimes heroic, and always confident, humans have an ability to work together toward common goals that makes them a force to be reckoned with. Though short-lived compared to other races, their boundless energy and drive allow them to accomplish much in their brief lifetimes.");

        Scanner input = new Scanner(System.in);
        int selection = getInput(input);
        switch (selection) {
            case 1:
                constitution += 2;
                wisdom += 2;
                charisma -= 2;
                System.out.println("Your racial attribute bonuses have been factored in. Please view the full racial abilities at https://www.d20pfsrd.com/races/core-races/dwarf/");
                race = "Dwarf";
                break;
            case 2:
                dexterity += 2;
                intelligence += 2;
                constitution -= 2;
                System.out.println("Your racial attribute bonuses have been factored in. Please view the full racial abilities at https://www.d20pfsrd.com/races/core-races/elf/");
                race = "Elf";
                break;
            case 3:
                constitution += 2;
                charisma += 2;
                strength -= 2;
                System.out.println("Your racial attribute bonuses have been factored in. Please view the full racial abilities at https://www.d20pfsrd.com/races/core-races/gnome/");
                race = "Gnome";
                break;
            case 4:
                randomStats();
                System.out.println("Your racial attribute bonuses have been factored in--for this, it was a random attribute. Please view the full racial abilities at https://www.d20pfsrd.com/races/core-races/half-elf/");
                race = "Half-Elf";
                break;
            case 5:
                randomStats();
                System.out.println("Your racial attribute bonuses have been factored in--for this, it was a random attribute. Please view the full racial abilities at https://www.d20pfsrd.com/races/core-races/half-orc/");
                race = "Half-Orc";
                break;
            case 6:
                dexterity += 2;
                charisma += 2;
                strength -= 2;
                System.out.println("Your racial attribute bonuses have been factored in. Please view the full racial abilities at https://www.d20pfsrd.com/races/core-races/halfling/");
                race = "Halfling";
                break;
            case 7:
                randomStats();
                System.out.println("Your racial attribute bonuses have been factored in--for this, it was a random attribute. Please view the full racial abilities at https://www.d20pfsrd.com/races/core-races/human/");
                race = "Human";
                break;
            default:
                System.out.println("Your input seems to be invalid, so we'll go with the most generic choice--humans.");
                randomStats();
                System.out.println("Your racial attribute bonuses have been factored in--for this, it was a random attribute. Please view the full racial abilities at https://www.d20pfsrd.com/races/core-races/human/");
                race = "Human";
                break;
        }

        System.out.println("=========================");
        System.out.println("Generating attributes.");
        strength += dropDice(4, 6, 1);
        dexterity += dropDice(4, 6, 1);
        constitution += dropDice(4, 6, 1);
        intelligence += dropDice(4, 6, 1);
        wisdom += dropDice(4, 6, 1);
        charisma += dropDice(4, 6, 1);
        int strBonus =  createBonus(strength);
        int dexBonus =  createBonus(dexterity);
        int conBonus =  createBonus(constitution);
        int intBonus =  createBonus(intelligence);
        int wisBonus =  createBonus(wisdom);
        int chaBonus =  createBonus(charisma);

        System.out.println("Strength: " +strength);
        System.out.println("Dexterity: " +dexterity);
        System.out.println("Constitution: " +constitution);
        System.out.println("Intelligence: " +intelligence);
        System.out.println("Wisdom: " +wisdom);
        System.out.println("Charisma: " +charisma);

        System.out.println("It's fun to keep these random. You can rearrange these as you please--but you'd have to do the math yourself, as the following results won't be accurate");
        System.out.println("=========================");
        System.out.println("Time to select a class. You're free to pick whichever, but think about what attributes someone of a particular class might need.");


        System.out.println("1: Barbarian: The barbarian is a brutal berserker from beyond the edge of civilized lands.");
        System.out.println("2: Bard: The bard uses skill and spell alike to bolster his allies, confound his enemies, and build upon his fame.");
        System.out.println("3: Cleric: A devout follower of a deity, the cleric can heal wounds, raise the dead, and call down the wrath of the gods.");
        System.out.println("4: Druid: The druid is a worshiper of all things natural – a spellcaster, a friend to animals, and a skilled shapechanger.");
        System.out.println("5: Fighter: Brave and stalwart, the fighter is a master of all manner of arms and armor. And this is a really long description that definitely goes over onto another line.");
        System.out.println("6: Monk: A student of martial arts, the monk trains his body to be his greatest weapon and defense.");
        System.out.println("7: Paladin: The paladin is the knight in shining armor, a devoted follower of law and good.");
        System.out.println("8: Ranger: A tracker and hunter, the ranger is a creature of the wild and of tracking down his favored foes.");
        System.out.println("9: Rogue: The rogue is a thief and a scout, an opportunist capable of delivering brutal strikes against unwary foes.");
        System.out.println("10: The spellcasting sorcerer is born with an innate knack for magic and has strange, eldritch powers.");
        System.out.println("11: Wizard: The wizard masters magic through constant study that gives him incredible magical power.");
        selection = getInput(input);

        switch(selection){
            case 1:
                baseHealth = 12+conBonus;
                baseAttackBonusMelee = 1+strBonus;
                baseAttackBonusRanged = 1+dexBonus;
                skillRanks = 4+intBonus;
                fortSave = 2+conBonus;
                willSave = 0+wisBonus;
                refSave = 0+dexBonus;
                System.out.println("Your statistical changes have been factored in.");
                playerClass = "Barbarian";
                break;
            case 2:
                baseHealth = 8+conBonus;
                baseAttackBonusMelee = 0+strBonus;
                baseAttackBonusRanged = 0+dexBonus;
                skillRanks = 6+intBonus;
                fortSave = 0+conBonus;
                willSave = 2+wisBonus;
                refSave = 2+dexBonus;
                System.out.println("Your statistical changes have been factored in. Check the links provided at the end for info on spells.");
                playerClass = "Bard";
                break;
            case 3:
                baseHealth = 8+conBonus;
                baseAttackBonusMelee = 0+strBonus;
                baseAttackBonusRanged = 0+dexBonus;
                skillRanks = 2+intBonus;
                fortSave = 2+conBonus;
                willSave = 2+wisBonus;
                refSave = 0+dexBonus;
                System.out.println("Your statistical changes have been factored in. Check the links provided at the end for info on spells.");
                playerClass = "Cleric";
                break;
            case 4:
                baseHealth = 8+conBonus;
                baseAttackBonusMelee = 0+strBonus;
                baseAttackBonusRanged = 0+dexBonus;
                skillRanks = 4+intBonus;
                fortSave = 2+conBonus;
                willSave = 2+wisBonus;
                refSave = 0+dexBonus;
                System.out.println("Your statistical changes have been factored in. Check the links provided at the end for info on spells.");
                playerClass = "Druid";
                break;
            case 5:
                baseHealth = 10+conBonus;
                baseAttackBonusMelee = 1+strBonus;
                baseAttackBonusRanged = 1+dexBonus;
                skillRanks = 2+intBonus;
                fortSave = 2+conBonus;
                willSave = 0+wisBonus;
                refSave = 0+dexBonus;
                System.out.println("Your statistical changes have been factored in.");
                playerClass = "Fighter";
                break;
            case 6:
                baseHealth = 8+conBonus;
                baseAttackBonusMelee = 0+strBonus;
                baseAttackBonusRanged = 0+dexBonus;
                skillRanks = 4+intBonus;
                fortSave = 2+conBonus;
                willSave = 2+wisBonus;
                refSave = 2+dexBonus;
                System.out.println("Your statistical changes have been factored in. Be careful, monk rules for attacking is strange.");
                playerClass = "Monk";
                break;
            case 7:
                baseHealth = 10+conBonus;
                baseAttackBonusMelee = 1+strBonus;
                baseAttackBonusRanged = 1+dexBonus;
                skillRanks = 2+intBonus;
                fortSave = 2+conBonus;
                willSave = 2+wisBonus;
                refSave = 0+dexBonus;
                System.out.println("Your statistical changes have been factored in. Check the links provided at the end for info on spells.");
                playerClass = "Paladin";
                break;
            case 8:
                baseHealth = 10+conBonus;
                baseAttackBonusMelee = 1+strBonus;
                baseAttackBonusRanged = 1+dexBonus;
                skillRanks = 6+intBonus;
                fortSave = 2+conBonus;
                willSave = 0+wisBonus;
                refSave = 2+dexBonus;
                System.out.println("Your statistical changes have been factored in.");
                playerClass = "Ranger";
                break;
            case 9:
                baseHealth = 8+conBonus;
                baseAttackBonusMelee = 0+strBonus;
                baseAttackBonusRanged = 0+dexBonus;
                skillRanks = 8+intBonus;
                fortSave = 0+conBonus;
                willSave = 0+wisBonus;
                refSave = 2+dexBonus;
                System.out.println("Your statistical changes have been factored in.");
                playerClass = "Rogue";
                break;
            case 10:
                baseHealth = 6+conBonus;
                baseAttackBonusMelee = 0+strBonus;
                baseAttackBonusRanged = 0+dexBonus;
                skillRanks = 2+intBonus;
                fortSave = 0+conBonus;
                willSave = 2+wisBonus;
                refSave = 0+dexBonus;
                System.out.println("Your statistical changes have been factored in. Check the links provided at the end for info on spells.");
                playerClass = "Sorcerer";
                break;
            case 11:
                baseHealth = 6+conBonus;
                baseAttackBonusMelee = 0+strBonus;
                baseAttackBonusRanged = 0+dexBonus;
                skillRanks = 2+intBonus;
                fortSave = 0+conBonus;
                willSave = 2+wisBonus;
                refSave = 0+dexBonus;
                System.out.println("Your statistical changes have been factored in. Check the links provided at the end for info on spells.");
                playerClass = "Wizard";
                break;
            default:
                System.out.println("ONLY COMMONERS INPUT INVALID THINGS");
                baseHealth = 6+conBonus;
                baseAttackBonusMelee = 0+strBonus;
                baseAttackBonusRanged = 0+dexBonus;
                skillRanks = 2+intBonus;
                fortSave = 0+conBonus;
                willSave = 0+wisBonus;
                refSave = 0+dexBonus;
                playerClass = "Commoner";
        }
        System.out.println("=========================");
        System.out.println("Now, you can choose to add one to either your number of skill ranks(1) or HP (2)");
        selection = selection = getInput(input);
        if(selection==1)
            skillRanks++;
        else if(selection==2)
            baseHealth++;
        else{
            System.out.println("That wasn't valid, so I'm going to default to health.");
            baseHealth++;
        }
        AC = 10 + dexBonus;
        initiative = dexBonus;

        System.out.println("=========================");
        System.out.println("That's all this program can help you with, besides carry weights that nobody uses! Here are your stats");

        System.out.println("Strength: " + strength + "/" + strBonus);
        System.out.println("Dexterity: " + dexterity + "/" + dexBonus);
        System.out.println("Constitution: " + constitution + "/" + conBonus);
        System.out.println("Intelligence: " + intelligence + "/" + intBonus);
        System.out.println("Wisdom: " + wisdom + "/" + wisBonus);
        System.out.println("Charisma: " + charisma + "/" + chaBonus);

        System.out.print("BAB(Meleee): " + baseAttackBonusMelee);
        System.out.print("; BAB(Ranged): " + baseAttackBonusRanged);
        System.out.println("; CMB: " +baseAttackBonusMelee); //they're the same at this level

        System.out.println("AC: " + AC);
        System.out.println("Initiative: " + initiative);
        System.out.println("Skill Ranks: " + skillRanks);

        System.out.print("Fortitude save: " + fortSave);
        System.out.print("; Will save: " + willSave);
        System.out.println("; Reflex save: " + refSave);

        System.out.println("For more information on your race, visit https://www.d20pfsrd.com/races/core-races/" + race);
        if(!playerClass.equals("Commoner"))
            System.out.println("For more information on your class, visit https://www.d20pfsrd.com/classes/core-classes/" + playerClass);
        else
            System.out.println("For more information on commoners, visit https://www.d20pfsrd.com/classes/npc-classes/commoner/");
    }




    //dropDice rolls a certain number of dice of a given type and drops the lowest.
    private static int dropDice(int diceNum, int diceType, int dropNum){ //TODO: Add handling for if dropNum >1. Thinking a nested for loop and/or decrementing dropNum
        int sum = 0;
        int minVal = diceType;
        int minIndex = 0;
        ArrayList<Integer> rolledDice = new ArrayList<Integer>();

        for(int i=0; i<diceNum; i++){ //Rolling the dice!
            rolledDice.add((int) (Math.random() * diceType )+1);
        }
        Collections.sort(rolledDice);
            for(int i=0; i < dropNum; i++){
                rolledDice.remove(0);
        }

        for(int i= 0; i<rolledDice.size(); i++){
            sum += rolledDice.get(i);
        }

        return sum;
    }

    private static void randomStats()
    {
        int attribute = (int) (Math.random()*6)+1;
        if(attribute==1)
            strength += 2;
        else if(attribute==2)
            dexterity += 2;
        else if(attribute==3)
            constitution += 2;
        else if(attribute==4)
            intelligence += 2;
        else if(attribute==5)
            wisdom += 2;
        else if(attribute==6)
            charisma += 2;
    }

    private static int createBonus(int attribute){
        int bonus = (attribute-10)/2;
        if(attribute % 2 != 0 && attribute <10) //Due to integer division and that PF applies a -1 at 9; -3 at 7; etc
            bonus--;
        return bonus;
    }

    private static int getInput(Scanner in){
        try {
            int choice = in.nextInt();
            in.nextLine();
            return choice;
        }
        catch(Exception InputMismatchException){
            in.nextLine();
            return 0;
        }
    }
}


