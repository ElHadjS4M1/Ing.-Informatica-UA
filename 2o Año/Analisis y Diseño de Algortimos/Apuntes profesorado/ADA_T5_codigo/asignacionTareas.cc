// Análisis y diseño de algoritmos. 
// Heurísticas voraces para el problema de la asignación de tareas.

#include <iostream>
#include <limits>
#include <vector>
#include <algorithm>

using namespace std;

const unsigned CANNOT = 100;
const unsigned TAM = 100;

typedef unsigned Table[TAM][TAM];
typedef vector<int> Assignment;

//-------------------------------------------------------------------
void fill_table( Table table, unsigned n ) { //random values in [0..9]

	for( unsigned e = 0; e < n; e++ )
		for( unsigned t = 0; t < n; t++ ){
			table[e][t] = rand() % 10;
			if (! (rand()%5) ) table[e][t] = CANNOT;  // 20% of CANNNOT's
		}
}

//-------------------------------------------------------------------
void print_problem( Table table, unsigned n ) {
	cout << n << endl;
	for( unsigned e = 0; e < n; e++ ) {
		for( unsigned t = 0; t < n; t++ ) 
		    if (table[e][t] == CANNOT) cout << "- ";
			else cout << table[e][t]  << " ";
		cout << endl;
	}
}

//-------------------------------------------------------------------
void print_greedy_solution(Table table, const Assignment &assignment, unsigned n){
	for( unsigned e = 0; e < n; e++ ) {
		for( unsigned t = 0; t < n; t++ ) 
		    if (assignment[e]==t) cout << table[e][t] << " | ";
		    else cout << "  | ";
		cout << endl;
    }
    cout << endl;
}

//-------------------------------------------------------------------
// Greedy criteria 1: Assign to each employee the task of minimum cost available.
// Time complexity O(n^2) exact.
namespace Greedy_criteria_1 {
    bool solve_greedy( Table table, unsigned &cost, Assignment &assignment ) {

	    unsigned num_employees = assignment.size();
	    unsigned num_tasks = num_employees;	
	
	    vector<bool> t_selected( num_tasks, false );
	    cost = 0;

    	for( unsigned e = 0; e < num_employees; e++ ){
    		unsigned min = numeric_limits<int>::max();
    		unsigned task;
    		for( unsigned t = 0; t < num_tasks; t++ )
    			if( !t_selected[t] && table[e][t] < min ) {
    				min = table[e][t];
    				task = t;
    			}
    		if (min == CANNOT)
    	        return false; //no solution found (but it may exist)
    	    assignment[e] = task;
    		t_selected[task] = true;
        	cost += min;		
    	}
    	return true; //found a solution (but it may not be the best)
    }

}
//-------------------------------------------------------------------
//	Greedy criteria 2: Select n minimums from the entire matrix 
//                     without repeating an employee or a task.
// Time complexity O(n^2 log(n)) exact. (but this criteria is more accurate in general)
namespace Greedy_criteria_2 {
    bool solve_greedy( Table table, unsigned &cost, Assignment &assignment ) {

	    unsigned n = assignment.size();
	
	    vector <unsigned> idx (n*n);
	    for (unsigned i=0; i<n*n; i++) idx[i]=i;
	    
	    sort (idx.begin(), idx.end(), 
	          [table,n]( unsigned x, unsigned y ){ 
	            return  table[x/n][x%n] < table[y/n][y%n];
	          } 
	         );

        unsigned count = 0;
        vector<bool> t_selected( n, false );
        cost=0;
        
        for( auto i: idx){
            unsigned e = i/n;
            unsigned t = i%n;
            unsigned current_min = table[e][t];
            if (current_min==CANNOT)
                return false; //no solution found (but it may exist)
            if (! (assignment[e]!=-1 or t_selected[t]) ){
                t_selected[t] = true;
                assignment[e] = i%n;
                cost += current_min;
                count++;
            }
            if (count == n)
                break;
        }
        return true; //found a solution (but it may not be the best)
    }
}

//--------------------------------------------------------------------	
int main( int argc, char *argv[]) {

	srand(time(NULL));

	Table table;
	unsigned num_employees = 10;
	fill_table( table, num_employees); 

    print_problem( table, num_employees);
    
	cout << "----------------" << endl;
    
    { // Greedy criteria 1
        vector<int> assignment(num_employees,-1);
        unsigned best_greedy;
        cout << "Greedy criteria 1: ";
        if (Greedy_criteria_1::solve_greedy( table, best_greedy, assignment) )
            cout << best_greedy << endl;
        else
            cout << "Solution not found." << endl;
        print_greedy_solution( table, assignment, num_employees);
    }
	
    { // Greedy criteria 2
        vector<int> assignment(num_employees,-1);
        unsigned best_greedy;
        cout << "Greedy criteria 2: ";
        if (Greedy_criteria_2::solve_greedy( table, best_greedy, assignment) )
            cout << best_greedy << endl;
        else
            cout << "Solution not found." << endl;
        print_greedy_solution( table, assignment, num_employees);
    }

    return 0;
}

