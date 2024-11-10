def time_to_seconds(time_str):
    minutes, seconds = map(int, time_str.split(':'))
    return minutes * 60 + seconds

def seconds_to_time(seconds):
    minutes, seconds = divmod(seconds, 60)
    return f"{minutes:02d}:{seconds:02d}"

def solution(video_len, pos, op_start, op_end, commands):
    video_len = time_to_seconds(video_len)
    current_pos = time_to_seconds(pos)
    op_start = time_to_seconds(op_start)
    op_end = time_to_seconds(op_end)

    for command in commands:
        if op_start <= current_pos <= op_end:
            current_pos = op_end

        if command == "prev":
            current_pos = max(0, current_pos - 10)
        elif command == "next":
            current_pos = min(video_len, current_pos + 10)

    # 마지막 명령 실행 후 한 번 더 오프닝 체크
    if op_start <= current_pos <= op_end:
        current_pos = op_end

    return seconds_to_time(current_pos)
