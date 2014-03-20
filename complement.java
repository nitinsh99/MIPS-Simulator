import java.io.FileWriter;
import java.io.IOException;

public class complement {
	
	
	public static void printData(String inst) throws IOException
	{
		
		
		
		FileWriter writer = new FileWriter("disassembly.txt",true);
	
		if (inst.charAt(0) != '1')
		{
			writer.append(inst+"\t"+MIPSsim.counter+"\t "+Integer.parseInt(inst, 2)+"\n");
			simulator.memory.put(MIPSsim.counter,Integer.parseInt(inst, 2));
            //System.out.println(simulator.memory.get(MIPSsim.counter));

		}
        else {
            String number = inst.substring (1);
            int value = Integer.valueOf (number, 2);
            int x =-((-value) & 0x7fffffff);
            writer.append(inst+"\t"+MIPSsim.counter+"\t"+x+"\n");
            
            simulator.memory.put(MIPSsim.counter,x);
            //System.out.println(simulator.memory.get(MIPSsim.counter));
		
        }
		
		writer.close();
		 
	}

}
