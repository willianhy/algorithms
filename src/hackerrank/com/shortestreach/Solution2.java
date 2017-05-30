package hackerrank.com.shortestreach;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Map;
	import java.util.Scanner;
	
	public class Solution2 {
		public static void main(String args[]){
			Scanner scan = new Scanner(System.in); 
			int numberOfQueries = scan.nextInt();
			Map<Integer, Nodee> nodes = new HashMap<Integer, Nodee>();
			for(int i = 0; i < numberOfQueries; i++){
				int numberOfNodes = scan.nextInt();
				int numberOfEdges = scan.nextInt();
				
				for(int j = 1; j <= numberOfNodes; j++)
					nodes.put(j, new Nodee(j));
				
				for(int j = 1; j <= numberOfEdges; j++)
					nodes.get(scan.nextInt()).addChild(nodes.get(scan.nextInt()));
			
				int rootIndex = scan.nextInt();
				Nodee root = nodes.get(rootIndex);
				doTheJob(root);
				
				for(int x = 1; x <= numberOfNodes; x++){
					if (x == rootIndex)
						continue;
					
					System.out.print(nodes.get(x).pathValue + " ");
				}
				System.out.println();
				
			}
		}
		
		private static void doTheJob(Nodee node){
			
			LinkedList<Nodee> nodes = new LinkedList<Nodee>();
			node.pathValue = 0;
			nodes.add(node);
			while(!nodes.isEmpty()){
				Nodee n = nodes.remove();
				
				for (Nodee nodee : n.nodes) {
					if (nodee.pathValue == -1){
						nodee.pathValue = n.pathValue + 6;
						nodes.add(nodee);
					}
				}
			}
		}
	}
	
	class Nodee{
		int id;
		List<Nodee> nodes = new ArrayList<Nodee>();
		int pathValue = -1;
		
		Nodee(int id){
			this.id = id;
		}
		
		void addChild(Nodee child){
			nodes.add(child);
			child.nodes.add(this);
		}
	}
