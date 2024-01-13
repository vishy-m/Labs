//v1.1
import java.util.*;
public class Tester10HashMaps extends TestGUI.TestData{ 
    public static void main (String[] args) {        
        new TestGUI();   
    }

    /**
     * Run customized tests of various classes/method and custom build your GUI

     * TO CREATE A HEADER IN THE GUI
     *     void header(String name)
     *   
     *     Example:
     *     header("Histogram");

     * TO CREATE A MESSAGE/NOTE IN THE GUI
     *     void message(String information)
     *     void message(String information, boolean correct)
     *   
     *     Example:
     *     message("This portion of the assignment is optional and for extra credit only."); //default grey color
     *     message("I'm requesting that this method have a green background.", true) //green color
     *     message("I'm requesting that this method have a red background.", false) //red color
     *     

     * TO CREATE A BUTTON FOR LOADING SOURCE CODE / DATA FILES
     *     void srcButton(String sourceFileNamesCommaDelimited)
     *     void srcButton(String[] sourceFileNames)
     *     
     *     Example:
     *     srcButton("PracticeProblems, Data.txt");  //If file has no extension, .java is assumed
     *     srcButton(new String[]{"Car.java", "Truck.java", "DataFile.in"}

     * TO TEST A CONSTRUCTOR AND RECEIVE THE INSTANTIATED OBJECT:
     *     Object makeObject(String className, Object[] args)
     *     Object makeObject(String className, Object[] args, String inputScript)
     *
     *     Parameters:
     *     className - Name of the constructor you are calling
     *     args - arguments you are passing to the constructor.  null can be used if calling a default 
     *            (no parameter) constructor
     *     inputScript - data that will be fed through System.in in the event that the constructor
     *         requests user input
     *      
     *     Returns:
     *     the object constructed from the call
     *      
     *     Example usage:
     *     //Using this...                                              // is similar to using this... 
     *     Object o = makeObject("Person", new Object[]{"Fred", 27});   // Object o = new Person("Fred", 27);
     *     Object o = makeObject("Person", null, "Fred\n27");           // Object o = new Person(); (provides user input)          

     * TO TEST A METHOD  (The testMethod method is very overloaded.  You have several options.)
     *     Object testMethod(Object o,     String mName, Object[] args)
     *     Object testMethod(String cName, String mName, Object[] args)
     *     Object testMethod(Object o,     String mName, Object[] args, String expOut)
     *     Object testMethod(String cName, String mName, Object[] args, String expOut)
     *     Object testMethod(Object o,     String mName, Object[] args, String expOut, String inputScript)
     *     Object testMethod(String cName, String mName, Object[] args, String expOut, String inputScript)
     *   
     *     Parameters:
     *     o - the object invoking the method you want to test (for non-static methods)
     *     cName - name of the class invoking the method you want to test (for static methods)
     *     mName - name of the method being invoked
     *     args - arguments being passing to the method.  null can be used if the method being testing
     *            does not require any parameters.
     *     expOut - the expected output or return value from running the method
     *            If an expOut is provided the GUI will compare this against the actual output/return
     *            value from the test and make a comparison.  Leave this off or pass null if you don't want
     *            to make a red light/green light comparison against the actual output.)
     *     inputScript - data that will be fed through System.in in the event that the method
     *         requests user input
     *   
     *     Returns:
     *     the return value of the method being invoked (as Object)
     *     or null when testing void methods or the student code fails to run/throws exception
     *   
     *     Example usage:
     *     //Using this...                                               // is similar to using this... 
     *     testMethod(myHistogram, "encounter", new Object[]{7});        // myHistogram.encounter(7);
     *     testMethod("Practice", "printXs", new Object[]{4}, "xxxx")    // Practice.printXs(4); 
     *     int s = testMethod(myCar, "getSpeed", null, "55");            // int s = myCar.getSpeed();

     * TO GET A CLASS OBJECT FROM ITS NAME       
     *     Class getClassFromName(String className)
     *     
     *     Example usage:
     *     Class c = getClassFromName("Truck");  
     *     
     *     Note: Why would you want to do this?  This will allow you to collect various information about
     *     how students coded the class, useful for checking how well students understand class design and
     *     inheritance.  You can verify that the Truck class extends the Vehicle class. You can find out 
     *     how many declared fields the student included (vs how many fields were inherited.) Also, this is
     *     your only way to get a version of the Class object that uses the same ClassLoader as the TestGUI
     *     (in the event that you need to try to cast Object o as a student-coded Truck.)  For more info,
     *     read about the Class class here:  https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html 

     * TO SET HOW MANY SECONDS SHOULD BE WAITED BEFORE AN INDIVIDUAL TEST TIMES OUT
     *     setTimeOutSec(int seconds);  //how many seconds to wait before giving up.  (Default 2)
     *   
     */
    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(3);

        srcButton("HashMapProbs");
        header("Animal Sounds");                   
        testMethod("HashMapProbs", "zoo", new Object[]{},            
            "{cat=meow, dog=woof}\n\nName an animal >>> fish\nWhat sound does that animal make? >>> blub\n{cat=meow, fish=blub, dog=woof}\n\nChoose an animal to speak with >>> fish\nThe fish says blub\n\nNumber of key/value pairs >>> 3",
            "fish\nblub\nfish"
        );
        testMethod("HashMapProbs", "zoo", new Object[]{},            
            "{cat=meow, dog=woof}\n\nName an animal >>> dog\nWhat sound does that animal make? >>> ruff\n{cat=meow, dog=ruff}\n\nChoose an animal to speak with >>> monkey\nThe monkey says null\n\nNumber of key/value pairs >>> 2",
            "dog\nruff\nmonkey"
        );

        header("Multiple");                   
        testMethod("HashMapProbs", "multiple", new Object[]{"hello"},
            "{e=false, h=false, l=true, o=false}"
        );
        testMethod("HashMapProbs", "multiple", new Object[]{"salsa"},
            "{a=true, s=true, l=false}"
        );

        header("charWord");                   
        testMethod("HashMapProbs", "charWord", new Object[]{new String[] {"tea", "salt", "soda", "taco"}},
            "{s=saltsoda, t=teataco}"
        );
        testMethod("HashMapProbs", "charWord", new Object[]{new String[] {"banana", "apple", "cherry", "apricot", "coconut"}},
            "{a=appleapricot, b=banana, c=cherrycoconut}"
        );

        header("dreamAnalyzer");       
        Object o = testMethod("HashMapProbs", "dreamAnalyzer", new Object[]{},
                "Highest frequency word: the, 103\n{plane=1, together,=5, been=2, militancy=1, hands=2, bad=1, together.=1, motels=1, boys=2, areas=1, owners=1, your=2, these=1, score=1, path=1, finds=1, would=2, seared=1, people,=1, you=6, character.=1, sixty-three=1, gaining=1, solid=1, pass=1, discrimination.=1, nineteen=1, alabama,=2, opportunity=2, now.=1, unalienable=1, community=1, am=1, whose=2, an=5, -=1, american,=1, former=2, underestimate=1, as=15, equality.=1, at=4, languishes=1, left=1, vote.=1, millions=1, returns=1, violence.=1, travel,=1, day.=1, be=32, \"when=1, turn=1, cells.=1, symphony=1, pilgrims'=1, corners=1, see=1, refuse=2, by=7, civil=1, a=36, business=1, words=3, california.=1, i=14, children,=1, ago,=1, children.=1, march=1, the=103, lips=1, police=2, trials=1, difficulties=1, obvious=1, thank=1, desert=1, sweet=1, god=1, citizens=1, concerned.=1, republic=1, promise=1, girls=2, dramatize=1, down=2, hold=1, discords=1, red=1, catholics,=1, invigorating=1, awakening=1, lookout=1, sweltering=2, midst=1, negro's=2, emancipation=1, which=6, wrote=1, its=1, mountainside,=2, check=3, brotherhood.=3, jail=2, staggered=1, take=1, never=3, beacon=1, meaning,=1, crooked=1, little=3, colorado!=1, some=3, mountains=1, blank=1, rockies=1, for=6, back=7, cities,=1, cities.=1, content=2, fatal=1, society=1, appalling=1, defaulted=1, injustice.=1, end=1, carolina,=1, live=2, sit=1, emerges.=1, lodging=1, york.=1, almighty,=1, citizenship=1, bound=1, exalted,=1, go=7, unearned=1, independence,=1, last!\"=1, with=11, material=1, there=5, tribulations.=1, pledge=1, fresh=1, he=1, smaller=1, injustice=2, american=3, hope=2, years=5, america=5, frustrations=1, fatigue=1, sons=2, bitterness=1, four=1, fierce=1, narrow=1, join=2, funds.\"=1, if=2, dripping=1, in=18, men,=1, satisfied=5, made=3, momentous=1, nothing=1, foundations=1, signed=1, is=21, sense=1, jangling=1, it=6, protest=1, peaks=1, heavy=1, today.=2, decree=1, \"insufficient=1, even=1, today,=2, spot=1, walk,=1, legitimate=1, mighty=2, despair=1, become=1, larger=1, georgia,=1, hundred=4, pursuit=1, skin=1, magnificent=1, majestic=1, georgia!=1, summer=1, \"my=1, remind=1, suffering.=1, bodies,=1, rights=1, have=19, stand=2, sacred=1, together=2, table=1, king,=1, sadly=1, horrors=1, slums=1, jews=1, hallowed=1, off=2, places=2, louisiana,=1, able=8, liberty,=2, died,=1, mississippi=1, signing=1, return=1, capital=1, shake=1, city,=1, ring.=1, proclamation.=1, ring,=1, upon=1, northern=1, redemptive.=1, pray=1, that=23, dream.=2, high=1, prosperity.=1, insofar=1, all=7, new=5, daybreak=1, wallow=1, shall=5, guaranteed=1, real=1, my=4, equal.\"=1, withering=1, back.=1, dream=9, were=1, true=1, valley=3, land.=1, basic=1, heat=1, veterans=1, constitution=1, soul=1, snowcapped=1, mississippi.=1, racial=2, joyous=1, righteousness=1, transform=1, and=43, promissory=2, of=97, today=2, men=3, ghettos=1, luther=1, rooted=1, land=3, victim=1, somehow=1, transformed=2, stand,=1, physical=2, make=2, on=5, that:=1, ahead.=1, or=1, beginning.=1, rolls=1, negro=13, mississippi,=2, conduct=1, engage=1, martin=1, luxury=1, until=4, sing.=1, walk=2, nation=7, ring=9, determination=1, thee,=1, granted=1, beautiful=1, bank=1, mountain=4, meaning=1, let=14, friends,=1, poverty=1, state=4, promises=1, meeting=1, they=2, symbolic=1, thee=1, gradualism.=1, old=1, night=1, nullification,=1, sunlit=1, demand=1, something=1, glory=1, rude=1, himself=1, must=9, autumn=1, oppression,=1, cup=1, governor's=1, mobility=1, fact=1, captivity.=1, believe=2, unmindful=1, seek=1, long=5, bankrupt.=1, moment=2, prodigious=1, into=5, pride,=1, obligation,=1, last!=2, are=8, crippled=1, came=2, engulfed=1, where=4, so=3, free=3, usual.=1, situation=2, thirst=1, whirlwinds=1, one=11, ghetto=1, vaults=1, black=2, honoring=1, many=1, declaration=1, people=2, \"we=1, unspeakable=1, hill=2, face=1, marvelous=1, to=59, vast=1, open=1, storms=1, battered=1, but=6, creed:=1, country=1, presently=1, suffering=1, had=1, no,=2, quest=1, free.=1, south.=1, life,=1, white=4, inextricably=1, continue=2, deeds.=1, changed.=1, has=5, up=3, curvaceous=1, plain,=1, five=1, us=4, end,=1, those=2, realize=1, alone.=1, palace=1, devotees=1, given=1, waters=1, despair.=1, this=18, insufficient=1, justice.=4, spiritual,=1, gentiles,=1, protestants=1, warm=1, guilty=1, ocean=1, architects=1, leads=1, rights.=1, straight,=1, rights,=1, sing=2, one.=1, nation.=1, allow=1, nation,=1, rough=1, color=2, asking=1, needed=1, lord=1, father=1, manacles=1, we=31, life=1, democracy.=1, speed=1, nor=1, not=14, revealed,=1, urgency=2, now=5, every=10, vote=1, overlook=1, again=2, was=2, check:=1, stone=2, 1963=1, riches=1, condition.=1, later,=4, true.=1, time=5, revolt=1, rise=3, forever=1, force.=1, brothers.=1, check.=1, brothers,=1, shadow=1, 'tis=1, chains=1, hampshire.=1, truths=1, when=5, her=1, children=2, self-evident;=1, pennsylvania!=1, deeply=1, hew=1, heightening=1, lonely=1, presence=1, cash=2, struggle=2, slaves=2, give=1, still=4, hilltops=1, lives=1, work=2, come=9, satisfied?\"=1, creative=2, doors=1, knowing=2, light=1, tranquillity=1, cooling=1, lift=1, force=1, flesh=1, south=1, hamlet,=1, bright=1, discipline.=1, our=14, gain=1, out=3, rock=1, slave=1, fall=1, freedom=18, believes=1, satisfied,=1, tragic=1, nation's=1, dark=1, place=1, evidences=1, persecution=1, ring.\"=1, wrongful=1, low,=1, great=5, degenerate=1, lead=1, negro.=1, god's=3, cannot=5, stream.=1, hatred.=1, oasis=1, \"free=1, rightful=1, own=1, threshold=1, happiness.=1, discontent=1, quicksands=1, flames=1, drug=1, georgia=1, his=2, spite=1, desolate=1, only=1, justice=3, funds=1, from=18, highways=1, segregation=2, blow=1, day=9, hope.=2, marked=1, drinking=1, like=2, island=1, created=1, judged=1, distrust=1, hills=1, interposition=1, who=4, here=3, note=3, exile=1, their=4, faith=5, freedom.=1, can=4, security=1, tennessee!=1, winds=1, tranquilizing=1, steam=1, alleghenies=1, village=1, heir.=1, rest=1, process=1, molehill=1, will=26, satisfy=1, brutality.=2, jr.=1, also=1, say=2, sisters=1, instead=1, heights=1, neither=1, york=1, dignity=1}"
            );

        try {
            HashMap<String, Integer> map = (HashMap<String, Integer>) o;
            int count = map.get("dream");
            if (count == 9)
                message("You said that the token \"dream\" appears in the speech a total of " + count + " times.  You are right!", true);
            else
                message("You said that the token \"dream\" appears in the speech a total of " + count + " times.  Sorry, that's wrong.", false);
        } catch (Exception e) {
            message("Your dream analyzer didn't return the HashMap object that I can understand.", false);
        }

    }    
}