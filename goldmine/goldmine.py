#!/usr/bin/python

import sys
import argparse
import time
import random

parser = argparse.ArgumentParser(description='Get the test file')
parser.add_argument('--testfile', type=str, help="path to save the alignemnts to direcotry")

dr = ['l','d','u','r']
# Direction of movement
d = { 
    'l' : [0,-1],
    'r' : [0, 1],
    'd' : [1, 0],
    'u' : [-1,0]
}


# This function evaluates my current proposal
def evaluate_objective_function_on_proposal(moves):
    # Takes a proposal(list of moves) and evaluate it based on mine_map
    cur = list(start)
    pickaxe = 1
    score = 0
    try:
        for x in moves:
            
            if mine_map[d[x][0]+cur[0]][d[x][1]+cur[1]] == 10:  # Hurray I found a new axe, double my gold from now onwards!
                pickaxe *= 2
            elif mine_map[d[x][0]+cur[0]][d[x][1]+cur[1]] == -1:   # If it hits the wall this proposal is not valid
                return -100
            else:
                # increase the score based on what I found by moving in certain direction!
                score = score + mine_map[d[x][0]+cur[0]][d[x][1]+cur[1]] * pickaxe
            
            #print score
            cur[0] += d[x][0]
            cur[1] += d[x][1]
    except IndexError:
        # If it goes out of index, this proposal is not valid simply return the 
        #print d[x][0]+cur[0], d[x][1]+cur[1]
        return -100
    return score



def validate(moves):
    valid = set()
    valid.add( tuple(start) )
    cur = tuple(start)
    
    for i in range(len(moves)):
        if valid.add( (d[moves[i]][0]+cur[0], d[moves[i]][1]+cur[1]) ) == None:
            return False
        cur[0] += d[moves[i]][0]
        cur[1] += d[moves[i]][1]
        
    print True
    return true


#def shuffleProposal(moves):
#    random.shuffle(moves)
#    return moves

def randomProposal(moves):
    rows = len(mine_map)
    cols = len(mine_map[1])
    valid = set()
    #print start
    valid.add(tuple(start))
    cur = tuple(start)
    temp = cur
    
    for i in range(len(moves)):
        count = 0
        while temp in valid:
            count +=1
            if count > 4:
                return moves
            k = random.randrange(4)
            if d[dr[k]][0]+cur[0] < rows and d[dr[k]][0]+cur[0] >= 0 and  d[dr[k]][1]+cur[1] < cols and d[dr[k]][1]+cur[1] >= 0:
                temp = (d[dr[k]][0]+cur[0], d[dr[k]][1]+cur[1])
        
        #print cur, temp
        valid.add(temp)
        moves[i] = dr[k]
        cur = temp
        
    #print valid
    return moves
    
# def randomPairProposal(moves):
#     length = len(moves)
#     e1 = random.randrange(length)
#     e2 = random.randrange(length)
#     # swap these elements
#     temp = moves[e1]
#     moves[e1] = moves[e2]
#     moves[e2] = temp
#     return moves
    
# def randomLast2SwapProposal(moves):
#     return moves
#     
def randomLast2Proposal(moves):
    valid = set()
    valid.add(tuple(start))
    
    for i in range(len(moves)-2):
        valid.add( (d[moves[i]][0], d[moves[i]][1]) )
        cur = [d[moves[i]][0], d[moves[i]][1]]
    
    
    temp = tuple(cur)
    for i in range(2):
        while temp in valid:
            k = random.randrange(4)
            temp = (d[dr[k]][0]+cur[0], d[dr[k]][1]+cur[1])
        
        valid.add(temp)
        cur = temp
        moves[-1*(i+1)] = dr[k]
    
    return moves
# 
def randomLast4Proposal(moves):
    valid = set()
    valid.add(tuple(start))
    
    for i in range(len(moves)-4):
        valid.add( (d[moves[i]][0], d[moves[i]][1]) )
        cur = [d[moves[i]][0], d[moves[i]][1]]
    
    
    temp = tuple(cur)
    for i in range(4):
        while temp in valid:
            k = random.randrange(4)
            temp = (d[dr[k]][0]+cur[0], d[dr[k]][1]+cur[1])
        
        valid.add(temp)
        cur = temp
        moves[-1*(i+1)] = dr[k]
        
    return moves
#     
def randomLast8Proposal(moves):
    if len(moves) <= 8:
        return moves
        
    valid = set()
    valid.add(tuple(start))
    
    for i in range(len(moves)-8):
        valid.add( (d[moves[i]][0], d[moves[i]][1]) )
        cur = [d[moves[i]][0], d[moves[i]][1]]
    
    
    temp = tuple(cur)
    for i in range(8):
        while temp in valid:
            k = random.randrange(4)
            temp = (d[dr[k]][0]+cur[0], d[dr[k]][1]+cur[1])
        
        valid.add(temp)
        cur = temp
        moves[-1*(i+1)] = dr[k]
        
    return moves
#     
def randomLastKProposal(moves):
    k = random.randrange(len(moves))
    valid = set()
    valid.add(tuple(start))
    
    for i in range(len(moves)-k):
        valid.add( (d[moves[i]][0], d[moves[i]][1]) )
        cur = [d[moves[i]][0], d[moves[i]][1]]
    
    
    temp = tuple(cur)
    for i in range(k):
        while temp in valid:
            k = random.randrange(4)
            temp = (d[dr[k]][0]+cur[0], d[dr[k]][1]+cur[1])
        
        valid.add(temp)
        cur = temp
        moves[-1*(i+1)] = dr[k]
        
    return moves
    
    
def randomMixProposals(moves):
    # import pdb
    # pdb.set_trace()
    k = random.randrange(len(proposals))
    return proposals[k](moves)
    
def local_search(num_moves,init_moves, epsilon, time_delta):
    # takes number of moves, initial moves, epsilon, and time in seconds
    best_score_so_far = 0
    best_moves_so_far = init_moves
    #moves = list(best_moves_so_far)

    start_time = time.time()
    while (time.time() - start_time) < time_delta :
        moves = list(best_moves_so_far)
        # Get a random proposal from randomMixProposal function
        moves = randomMixProposals(moves)
        if not validate(moves):
            continue
        #print moves
        # Evaluate the given proposal and calculate the score
        score = evaluate_objective_function_on_proposal(moves)
        #print score
        if( score - best_score_so_far >= epsilon):
            best_score_so_far = score
            best_moves_so_far = list(moves)
            print score
            print best_moves_so_far

    return (best_score_so_far, best_moves_so_far)


# The list of proposal functions used!
proposals = [
#    shuffleProposal,
    randomProposal,
    # randomPairProposal,
    # randomLast2SwapProposal,
    # randomLast2Proposal,
#     randomLast4Proposal,
#     randomLastKProposal,
#     randomLast8Proposal
]
    
# Start from here!
if __name__ == '__main__':
    # Parse the arguments to get the test file
    args = parser.parse_args()
    
    # Open the test file
    f = open(args.testfile,'r')
    
    # get the size of matrix and the number of moves
    line = f.readline()
    line.strip()
    # parse the line
    words = line.lstrip('=').split(',')
    # Create the mine map 
    global mine_map
    mine_map = [[0]*int(words[0]) for i in range(int(words[1]))]
    num_moves = int(words[2])
    global start 
    start = []
    #global moves = [0]*num_moves
    
    # Fill up the mine map
    for i in range(int(words[0])):
        line = f.readline().strip()
        j=0
        for char in line:
            if char == 'd':
                mine_map[i][j] = 10
            elif char == '.':
                mine_map[i][j] = 0
            elif char == 'w':
                mine_map[i][j] = -1
            elif char =='s':
                mine_map[i][j] = 0
                start.append(i)
                start.append(j)
            else:
                mine_map[i][j] = int(char)
                
            j += 1
                
    # okay map is now generated 
    
    # Test the mine_map and evaluation function
    for l in mine_map:
        print l
        
    #moves = ['r','d','d','d','d','l','u','l']
    #print num_moves
    #print moves
    #print evaluate_objective_function_on_proposal(moves)
    f.close()
    # Gold Mine runner
    initial_moves = []
    for i in range(num_moves):
        initial_moves.append( dr[random.randrange(4)] )
        
    #initial_moves = ['l','r']
    epsilon = -1
    time_frame = 20
    answer = local_search(num_moves, initial_moves, epsilon, time_frame)
    print answer[0]
    print answer[1]
    