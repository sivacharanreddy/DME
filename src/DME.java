
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author charan
 */
public class DME {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("enter size of network: ");
        Scanner process=new Scanner(System.in);
        int nop=process.nextInt();
        int a[][]=new int[nop][nop];
        
		int tokennode_val=100;
                int no_of_requests=1+(int)(5*Math.random());
                System.out.println("The total number of requests are:" +no_of_requests);
		int x_token,y_token,x_req,y_req;
                int p[]= new int[no_of_requests];
                int q[]= new int[no_of_requests];
		x_token=(int) (nop*Math.random());
		y_token=(int) (nop*Math.random());
                //requested processes
                for(int r=0;r<no_of_requests;r++)
                {    
                    x_req=(int) (nop*Math.random());
                    y_req=(int) (nop*Math.random());
                    p[r]=x_req;
                    q[r]=y_req;
                }
             	  //a[x_token][y_token]=tokennode_val;
		int informed_row=0,counter=0,msg_counter=0;
                for(int i=0;i<nop;i++)
                {
                    int t=nop*i;
                    for(int j=0;j<nop;j++)
                    {
                        int x=j;
                        a[i][j]=t+(x+1);
                        
                    }
                }
                
                for(int r=0;r<no_of_requests;r++)
                {    
                    int e=p[r];
                    int f=q[r];
                    System.out.println("Requester Process: P"+a[e][f]+"("+e+" "+f+")");
                }
                System.out.println("\n"); 
                //creation of informed nodes
		for(int i=0;i<nop;i++)
		{
			if(i!=y_token)
			{
			//a[x_token][i]=1;//informed nodes
			}
		}
                int r=0;
                // row_req < row_token
                
                for(int ite=0;ite<no_of_requests;ite++){
                
                System.out.println("Token Holding process: P"+a[x_token][y_token]+"(" +x_token+" "+y_token+")");
                int m=p[r];
                int n=q[r];
		System.out.println("Requester process: P"+a[m][n]+"(" +m+" "+n+")");
                
		if(m<x_token || (m==x_token))
                {
                    for(int request_row=m;request_row<nop;request_row++)
                    {
			counter++;
                        
			if(request_row==x_token)
			{
				informed_row=request_row; //a[informed_row][y_req];
				msg_counter=counter;
                                break;
			}
                        System.out.println("Message reached process: P"+a[request_row+1][n]+"("+(request_row+1)+" "+n+")");
                    }
                    
                }
                //row_req>row_token
                else
                {
                   for(int i=m;i<nop;i++)
                   {
                       counter++;
                       int temp=0;
                       if(i==(nop-1))
                       {
                           System.out.println("Message reached process: P"+a[temp][n]+"("+(temp)+" "+n+")");
                       }
                       else
                       {
                           System.out.println("Message reached process: P"+a[i+1][n]+"("+(i+1)+" "+n+")");
                       }
                   }
                   for(int i=0;i<=x_token;i++)
                   {
                       counter++;
                       if(i==x_token)
			{
				informed_row=i; //a[informed_row][y_req];
				msg_counter=counter;
                                break;
			}
                       System.out.println("Message reached process: P"+a[i+1][n]+"("+(i+1)+" "+n+")");
                   }
                }
                   if(n<y_token)
                    {
                        for(int j=n;j<nop;j++)
                        {
                            if(j==y_token)
                            {
				if(x_token==m && y_token==n){
                                    System.out.println("Requester process and Token process are same");
                                    System.out.println("\n");}
                                else if(y_token==n)
                                {
                                System.out.println("Message reached process: P"+a[x_token][y_token]+"(" +x_token+" "+y_token+")");
                                System.out.println("Token received by process: P"+a[m][n]+"(" +m+" "+n+")");
                                System.out.println("Total number of messages are: "+(msg_counter-1));
                                System.out.println("\n");
                                }
                                else
                                {
                                System.out.println("Message reached process: P"+a[x_token][y_token]+"(" +x_token+" "+y_token+")");
                                System.out.println("Token received by process: P"+a[m][n]+"(" +m+" "+n+")"); 
                                System.out.println("Total number of messages are: "+(msg_counter));
                                System.out.println("\n");
                                }
                             
                            }
                        }
                    }
                    //y_req>y_token
                    else
                    {
                        for(int j=n;j>=y_token;j--)
                        {
                            if(j==y_token)
                            {
                                //req_processand token_processin same col
				if(x_token==m && y_token==n){
                                    System.out.println("Requester process and Token process are same");
                                    System.out.println("\n");}
                                else if(y_token==n)
                                {
                                System.out.println("Message reached process: P"+a[x_token][y_token]+"(" +x_token+" "+y_token+")");
                                System.out.println("Token received by process: P"+a[m][n]+"(" +m+" "+n+")"); 
                                System.out.println("Total number of messages are: "+(msg_counter-1));
                                System.out.println("\n");
                                }
                                else
                                {
                                System.out.println("Message reached process: P"+a[x_token][y_token]+"(" +x_token+" "+y_token+")");
                                System.out.println("Token received by process: P"+a[m][n]+"(" +m+" "+n+")");
                                System.out.println("Total number of messages are: "+(msg_counter));
                                System.out.println("\n");
                                }
                            }
                        }
                    }
                   
                   x_token=m;
                   y_token=n;
                   r=r+1;
                   counter=0;
                   
                }

                } 
                
    }
                 



                
                
               			
	

