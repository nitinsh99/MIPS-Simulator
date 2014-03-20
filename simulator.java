import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class simulator {
	
	public static int[] register = new int[32];
	public static Map<Integer,Integer> memory = new HashMap<Integer,Integer>();
	public static Map<Integer,String> inst_map = new HashMap<Integer,String>();

	public static boolean breakCheck1=false;
	public static int counter1=128;
	public static int cycle=1;
	public static int rowCheck=0;
	
	public static void simulate() throws IOException
	{
		String string;
		//File file = new File(args[0]);
		FileReader fr = new FileReader(MIPSsim.file.getAbsolutePath());
		BufferedReader br = new BufferedReader(fr);
		//string = br.readLine();
		FileWriter writer = new FileWriter("simulation.txt",true);
		
		
		while(breakCheck1 == false)
		{
			//string = br.readLine();
			//System.out.println(counter1);

			string = inst_map.get(counter1);
			//System.out.println(string);
			if(string.substring(0,3).equalsIgnoreCase("110") && breakCheck1 == false)
					{
					if(string.substring(13,16).equalsIgnoreCase("000"))
					{
						//category2.add(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						
						writer.append("--------------------"+"\n");
						writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"ADD R"+Integer.parseInt(string.substring(16,21), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", R"+Integer.parseInt(string.substring(8,13), 2)+"\n");
						writer.append("\n");
						writer.append("Registers"+"\n");
						register[Integer.parseInt(string.substring(16,21),2)] = register[Integer.parseInt(string.substring(3,8),2)]+register[Integer.parseInt(string.substring(8,13),2)];
						int temp=0,temp1;
						writer.append("R00:"+"\t");
						for(int i=0;i<4;i++)
						{
							
							for(int j=0;j<8;j++)
							{
								writer.append(""+register[temp++]);
								writer.append("\t");
							}
							writer.append("\n");
							if(temp!=32)
							{
								if(temp<10)
								{
									writer.append("R0"+temp+":"+"\t");
								}
								else
								{
									writer.append("R"+temp+":"+"\t");

									
								}
								

							}
							
						}
						writer.append("\n");
						writer.append("Data"+"\n");
						writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
						int rowCheck1=0;
						for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
						{
							
							if(rowCheck1==8)
							{
								writer.append("\n");
								writer.append(""+(temp1)+":"+"\t");
								rowCheck1=0;

							}
							writer.append(""+memory.get(temp1));
							writer.append("\t");
							rowCheck1++;
						}
						
						writer.append("\n");
						writer.append("\n");


						
						
						cycle++;
						counter1 += 4;
						
					}
					else if(string.substring(13,16).equalsIgnoreCase("001"))
					{
						//category2.sub(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						writer.append("--------------------"+"\n");
						writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"SUB R"+Integer.parseInt(string.substring(16,21), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", R"+Integer.parseInt(string.substring(8,13), 2)+"\n");
						writer.append("\n");
						writer.append("Registers"+"\n");
						register[Integer.parseInt(string.substring(16,21),2)] = register[Integer.parseInt(string.substring(3,8),2)]-register[Integer.parseInt(string.substring(8,13),2)];
						int temp=0,temp1;
						writer.append("R00:"+"\t");
						for(int i=0;i<4;i++)
						{
							
							for(int j=0;j<8;j++)
							{
								writer.append(""+register[temp++]);
								writer.append("\t");
							}
							writer.append("\n");
							if(temp!=32)
							{
								if(temp<10)
								{
									writer.append("R0"+temp+":"+"\t");
								}
								else
								{
									writer.append("R"+temp+":"+"\t");

									
								}
								

							}
							
						}
						writer.append("\n");
						writer.append("Data"+"\n");
						writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
						int rowCheck1=0;
						for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
						{
							
							if(rowCheck1==8)
							{
								writer.append("\n");
								writer.append(""+(temp1)+":"+"\t");
								rowCheck1=0;

							}
							writer.append(""+memory.get(temp1));
							writer.append("\t");
							rowCheck1++;
						}
						writer.append("\n");
						writer.append("\n");


						
						
						cycle++;
						counter1 += 4;
						
					}
					
					else if(string.substring(13,16).equalsIgnoreCase("010"))
					{
						//category2.mul(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						//category2.sub(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						writer.append("--------------------"+"\n");
						writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"MUL R"+Integer.parseInt(string.substring(16,21), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", R"+Integer.parseInt(string.substring(8,13), 2)+"\n");
						writer.append("\n");
						writer.append("Registers"+"\n");
						register[Integer.parseInt(string.substring(16,21),2)] = register[Integer.parseInt(string.substring(3,8),2)]*register[Integer.parseInt(string.substring(8,13),2)];
						int temp=0,temp1,temp2;
						writer.append("R00:"+"\t");
						for(int i=0;i<4;i++)
						{
							
							for(int j=0;j<8;j++)
							{
								writer.append(""+register[temp++]);
								writer.append("\t");
							}
							writer.append("\n");
							if(temp!=32)
							{
								if(temp<10)
								{
									writer.append("R0"+temp+":"+"\t");
								}
								else
								{
									writer.append("R"+temp+":"+"\t");

									
								}
								

							}
							
						}
						writer.append("\n");
						writer.append("Data"+"\n");
						writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
						int rowCheck1=0;
						for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
						{
							
							if(rowCheck1==8)
							{
								writer.append("\n");
								writer.append(""+(temp1)+":"+"\t");
								rowCheck1=0;

							}
							writer.append(""+memory.get(temp1));
							writer.append("\t");
							rowCheck1++;
						}
						writer.append("\n");
						writer.append("\n");


						
						
						cycle++;
						counter1 += 4;
						

						
					}
					else if(string.substring(13,16).equalsIgnoreCase("011"))
					{
						//category2.and(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						//category2.sub(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						writer.append("--------------------"+"\n");
						writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"AND R"+Integer.parseInt(string.substring(16,21), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", R"+Integer.parseInt(string.substring(8,13), 2)+"\n");
						writer.append("\n");
						writer.append("Registers"+"\n");
						register[Integer.parseInt(string.substring(16,21),2)] = register[Integer.parseInt(string.substring(3,8),2)]&register[Integer.parseInt(string.substring(8,13),2)];
						int temp=0,temp1,temp2;
						writer.append("R00:"+"\t");
						for(int i=0;i<4;i++)
						{
							
							for(int j=0;j<8;j++)
							{
								writer.append(""+register[temp++]);
								writer.append("\t");
							}
							writer.append("\n");
							if(temp!=32)
							{
								if(temp<10)
								{
									writer.append("R0"+temp+":"+"\t");
								}
								else
								{
									writer.append("R"+temp+":"+"\t");

									
								}
								

							}
							
						}
						writer.append("\n");
						writer.append("Data"+"\n");
						writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
						int rowCheck1=0;
						for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
						{
							
							if(rowCheck1==8)
							{
								writer.append("\n");
								writer.append(""+(temp1)+":"+"\t");
								rowCheck1=0;

							}
							writer.append(""+memory.get(temp1));
							writer.append("\t");
							rowCheck1++;
						}
						writer.append("\n");
						writer.append("\n");


						
						
						cycle++;
						counter1 += 4;

						
					}
					else if(string.substring(13,16).equalsIgnoreCase("100"))
					{
						//category2.or(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						//category2.sub(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						writer.append("--------------------"+"\n");
						writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"OR R"+Integer.parseInt(string.substring(16,21), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", R"+Integer.parseInt(string.substring(8,13), 2)+"\n");
						writer.append("\n");
						writer.append("Registers"+"\n");
						register[Integer.parseInt(string.substring(16,21),2)] = register[Integer.parseInt(string.substring(3,8),2)]|register[Integer.parseInt(string.substring(8,13),2)];
						int temp=0,temp1,temp2;
						writer.append("R00:"+"\t");
						for(int i=0;i<4;i++)
						{
							
							for(int j=0;j<8;j++)
							{
								writer.append(""+register[temp++]);
								writer.append("\t");
							}
							writer.append("\n");
							if(temp!=32)
							{
								if(temp<10)
								{
									writer.append("R0"+temp+":"+"\t");
								}
								else
								{
									writer.append("R"+temp+":"+"\t");

									
								}
								

							}
							
						}
						writer.append("\n");
						writer.append("Data"+"\n");
						writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
						int rowCheck1=0;
						for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
						{
							
							if(rowCheck1==8)
							{
								writer.append("\n");
								writer.append(""+(temp1)+":"+"\t");
								rowCheck1=0;

							}
							writer.append(""+memory.get(temp1));
							writer.append("\t");
							rowCheck1++;
						}
						writer.append("\n");
						writer.append("\n");


						
						
						cycle++;
						counter1 += 4;

						
					}
					else if(string.substring(13,16).equalsIgnoreCase("101"))
					{
						//category2.xor(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						//category2.sub(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						writer.append("--------------------"+"\n");
						writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"XOR R"+Integer.parseInt(string.substring(16,21), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", R"+Integer.parseInt(string.substring(8,13), 2)+"\n");
						writer.append("\n");
						writer.append("Registers"+"\n");
						register[Integer.parseInt(string.substring(16,21),2)] = register[Integer.parseInt(string.substring(3,8),2)]^register[Integer.parseInt(string.substring(8,13),2)];
						int temp=0,temp1,temp2;
						writer.append("R00:"+"\t");
						for(int i=0;i<4;i++)
						{
							
							for(int j=0;j<8;j++)
							{
								writer.append(""+register[temp++]);
								writer.append("\t");
							}
							writer.append("\n");
							if(temp!=32)
							{
								if(temp<10)
								{
									writer.append("R0"+temp+":"+"\t");
								}
								else
								{
									writer.append("R"+temp+":"+"\t");

									
								}
								

							}
							
						}
						writer.append("\n");
						writer.append("Data"+"\n");
						writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
						int rowCheck1=0;
						for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
						{
							
							if(rowCheck1==8)
							{
								writer.append("\n");
								writer.append(""+(temp1)+":"+"\t");
								rowCheck1=0;

							}
							writer.append(""+memory.get(temp1));
							writer.append("\t");
							rowCheck1++;
						}
						writer.append("\n");
						writer.append("\n");


						
						
						cycle++;
						counter1 += 4;

						
					}
					else if(string.substring(13,16).equalsIgnoreCase("110"))
					{
						//category2.nor(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						//category2.sub(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
						//counter += 4;
						writer.append("--------------------"+"\n");
						writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"NOR R"+Integer.parseInt(string.substring(16,21), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", R"+Integer.parseInt(string.substring(8,13), 2)+"\n");
						writer.append("\n");
						writer.append("Registers"+"\n");
						register[Integer.parseInt(string.substring(16,21),2)] = ~(register[Integer.parseInt(string.substring(3,8),2)]|register[Integer.parseInt(string.substring(8,13),2)]);
						int temp=0,temp1,temp2;
						writer.append("R00:"+"\t");
						for(int i=0;i<4;i++)
						{
							
							for(int j=0;j<8;j++)
							{
								writer.append(""+register[temp++]);
								writer.append("\t");
							}
							writer.append("\n");
							if(temp!=32)
							{
								if(temp<10)
								{
									writer.append("R0"+temp+":"+"\t");
								}
								else
								{
									writer.append("R"+temp+":"+"\t");

									
								}
								

							}
							
						}
						writer.append("\n");
						writer.append("Data"+"\n");
						writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
						int rowCheck1=0;
						for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
						{
							
							if(rowCheck1==8)
							{
								writer.append("\n");
								writer.append(""+(temp1)+":"+"\t");
								rowCheck1=0;

							}
							writer.append(""+memory.get(temp1));
							writer.append("\t");
							rowCheck1++;
						}
						writer.append("\n");
						writer.append("\n");


						
						
						cycle++;
						counter1 += 4;

						
					}
					else
					{
						//category2.error();
						//counter += 4;

					}
					
				
					}
			
			else if(string.substring(0,3).equalsIgnoreCase("111") && breakCheck1 == false)
			{
				if(string.substring(13,16).equalsIgnoreCase("000"))
				{
					//category3.addi(string, string.substring(3,8),string.substring(8,13), string.substring(16,32));
					//counter += 4;
					//category2.sub(string, string.substring(3,8),string.substring(8,13), string.substring(16,21));
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"ADDI R"+Integer.parseInt(string.substring(8,13), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", #"+Integer.parseInt(string.substring(16,32), 2)+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					register[Integer.parseInt(string.substring(8,13),2)] = register[Integer.parseInt(string.substring(3,8),2)]+Integer.parseInt(string.substring(16,32),2);
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					
					cycle++;
					counter1 += 4;
					
				}
				else if(string.substring(13,16).equalsIgnoreCase("001"))
				{
					//category3.andi(string, string.substring(3,8),string.substring(8,13), string.substring(16,32));
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"ANDI R"+Integer.parseInt(string.substring(8,13), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", #"+Integer.parseInt(string.substring(16,32), 2)+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					register[Integer.parseInt(string.substring(8,13),2)] = register[Integer.parseInt(string.substring(3,8),2)]&Integer.parseInt(string.substring(16,32),2);
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					
					cycle++;
					counter1 += 4;
					
				}
				else if(string.substring(13,16).equalsIgnoreCase("010"))
				{
					//category3.ori(string, string.substring(3,8),string.substring(8,13), string.substring(16,32));
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"ORI R"+Integer.parseInt(string.substring(8,13), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", #"+Integer.parseInt(string.substring(16,32), 2)+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					register[Integer.parseInt(string.substring(8,13),2)] = register[Integer.parseInt(string.substring(3,8),2)]|Integer.parseInt(string.substring(16,32),2);
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					
					cycle++;
					counter1 += 4;
					
				}
				else if(string.substring(13,16).equalsIgnoreCase("001"))
				{
					//category3.xori(string, string.substring(3,8),string.substring(8,13), string.substring(16,32));
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"XORI R"+Integer.parseInt(string.substring(8,13), 2)+", R"+Integer.parseInt(string.substring(3,8), 2)+", #"+Integer.parseInt(string.substring(16,32), 2)+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					register[Integer.parseInt(string.substring(8,13),2)] = register[Integer.parseInt(string.substring(3,8),2)]^Integer.parseInt(string.substring(16,32),2);
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					
					cycle++;
					counter1 += 4;
					
				}
				else
				{
					//category3.error();
					//counter += 4;

				}
				
				
				
			}
			
			else if(string.substring(0,3).equalsIgnoreCase("000") && breakCheck1 == false)
			{
				if(string.substring(3,6).equalsIgnoreCase("000"))
				{
					//category1.j(string, string.substring(6,32)+"00");
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"J #"+Integer.parseInt(string.substring(6,32)+"00", 2)+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					counter1=Integer.parseInt(string.substring(6,32)+"00", 2);
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					
					cycle++;
					
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("010"))
				{
					//category1.beq(string, string.substring(6,11),string.substring(11,16), string.substring(16,32)+"00");
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"BEQ R"+Integer.parseInt(string.substring(6,11), 2)+", R"+Integer.parseInt(string.substring(11,16), 2)+", #"+Integer.parseInt(string.substring(16,32)+"00", 2)+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					counter1+=4;
					if(register[Integer.parseInt(string.substring(6,11), 2)] == register[Integer.parseInt(string.substring(11,16), 2)] )
					{
						counter1+=Integer.parseInt(string.substring(16,32)+"00", 2);
						//counter1=180;

					}
					//else
					//{
						//counter1 += 4;
					//}
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					
					cycle++;
					
					
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("100"))
				{
					//category1.bgtz(string, string.substring(6,11), string.substring(16,32)+"00");
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"BGTZ R"+Integer.parseInt(string.substring(6,11), 2)+", #"+Integer.parseInt(string.substring(16,32)+"00", 2)+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					//System.out.println(Integer.parseInt(string.substring(16,32)+"00", 2));
					counter1+=4;
					
					if(register[Integer.parseInt(string.substring(6,11),2)] >0)
					{
						//System.out.println(counter1);

						counter1 += (Integer.parseInt(string.substring(16,32)+"00",2));
						//counter1=164;
						//int temp = Integer.parseInt(string.substring(16,32)+"00",2);
						//System.out.println(temp);



					}
					/*else
					{
						counter1 += 4;
					}*/
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					
					cycle++;
					
					
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("101"))
				{
					breakCheck1 = true;
					//category1.breakfunc(string);
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"BREAK"+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					//writer.append("\n");


					
					
					
					
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("110"))
				{
					//category1.sw(string, string.substring(6,11),string.substring(11,16),string.substring(16,32));
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"SW R"+Integer.parseInt(string.substring(11,16), 2)+", "+Integer.parseInt(string.substring(16,32), 2)+"(R"+Integer.parseInt(string.substring(6,11), 2)+")"+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					
					memory.put(Integer.parseInt(string.substring(16,32), 2)+register[Integer.parseInt(string.substring(6,11), 2)],register[Integer.parseInt(string.substring(11,16), 2)]) ;
					
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					counter1 += 4;
					cycle++;
					
					
					
					
				}
				else if(string.substring(3,6).equalsIgnoreCase("111"))
				{
					//category1.lw(string, string.substring(6,11),string.substring(11,16),string.substring(16,32));
					//counter += 4;
					writer.append("--------------------"+"\n");
					writer.append("Cycle:"+cycle+"  "+counter1+"\t"+"LW R"+Integer.parseInt(string.substring(11,16), 2)+", "+Integer.parseInt(string.substring(16,32), 2)+"(R"+Integer.parseInt(string.substring(6,11), 2)+")"+"\n");
					writer.append("\n");
					writer.append("Registers"+"\n");
					
					//System.out.println(memory.get(184));
					
					register[Integer.parseInt(string.substring(11,16), 2)]=memory.get(register[Integer.parseInt(string.substring(6,11), 2)]+Integer.parseInt(string.substring(16,32), 2)) ;
					
					int temp=0,temp1,temp2;
					writer.append("R00:"+"\t");
					for(int i=0;i<4;i++)
					{
						
						for(int j=0;j<8;j++)
						{
							writer.append(""+register[temp++]);
							writer.append("\t");
						}
						writer.append("\n");
						if(temp!=32)
						{
							if(temp<10)
							{
								writer.append("R0"+temp+":"+"\t");
							}
							else
							{
								writer.append("R"+temp+":"+"\t");

								
							}
							

						}
						
					}
					writer.append("\n");
					writer.append("Data"+"\n");
					writer.append(""+(MIPSsim.break_record+4)+":"+"\t");
					int rowCheck1=0;
					for(temp1=MIPSsim.break_record+4;temp1<MIPSsim.counter;temp1+=4)
					{
						
						if(rowCheck1==8)
						{
							writer.append("\n");
							writer.append(""+(temp1)+":"+"\t");
							rowCheck1=0;

						}
						writer.append(""+memory.get(temp1));
						writer.append("\t");
						rowCheck1++;
					}
					writer.append("\n");
					writer.append("\n");


					
					counter1 += 4;
					cycle++;
					
					
				}
				else
				{
					//category1.error();
					//counter += 4;

				}
				
				
				
				
			}
			else
			{
				//complement.printData(string);
				//counter += 4;
			}
			
		}
		
		br.close();
		writer.close();
	}
	 
	

}
