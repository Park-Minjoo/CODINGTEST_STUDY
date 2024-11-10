import heapq
from collections import defaultdict

def solution(program):
    program.sort(key=lambda x: (x[1], x[0]))

    time = 0
    idx = 0
    wait_times = defaultdict(int)
    queue = []

    while idx < len(program) or queue:
        while idx < len(program) and program[idx][1] <= time:
            heapq.heappush(queue, (program[idx][0], program[idx][1], program[idx][2]))
            idx += 1

        if queue:
            score, call_time, exec_time = heapq.heappop(queue)
            wait_time = time - call_time
            wait_times[score] += wait_time
            time += exec_time
        else:
            if idx < len(program):
                time = program[idx][1]
    answer = [time] + [wait_times[i] for i in range(1, 11)]
    return answer
