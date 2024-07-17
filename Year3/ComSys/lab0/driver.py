#!/usr/bin/python

import subprocess
import sys
import getopt

# Driver program for C programming exercise
class Tracer:
    traceDirectory = "./traces"
    qtest = "./qtest"
    verbLevel = 0
    autograde = False

    traceDict = {
        1 : "trace-01-ops",
        2 : "trace-02-ops",
        3 : "trace-03-ops",
        4 : "trace-04-ops",
        5 : "trace-05-ops",
        6 : "trace-06-string",
        7 : "trace-07-robust",
        8 : "trace-08-robust",
        9 : "trace-09-robust",
        10 : "trace-10-malloc",
        11 : "trace-11-malloc",
        12 : "trace-12-malloc",
        13 : "trace-13-perf",
        14 : "trace-14-perf",
        15 : "trace-15-perf"
    }

    traceProbs = {
        1 : "Trace-01",
        2 : "Trace-02",
        3 : "Trace-03",
        4 : "Trace-04",
        5 : "Trace-05",
        6 : "Trace-06",
        7 : "Trace-07",
        8 : "Trace-08",
        9 : "Trace-09",
        10 : "Trace-10",
        11 : "Trace-11",
        12 : "Trace-12",
        13 : "Trace-13",
        14 : "Trace-14",
        15 : "Trace-15"
    }

    maxScores = [0, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7]

    def __init__(self, qtest = "", verbLevel = 0, autograde = False):
        if qtest != "":
            self.qtest = qtest
        self.verbLevel = verbLevel
        self.autograde = autograde

    def runTrace(self, tid):
        if not tid in self.traceDict:
            print(f"ERROR: No trace with id {tid}")
            return False
        fname = f"{self.traceDirectory}/{self.traceDict[tid]}.cmd"
        vname = f"{self.verbLevel}"
        clist = [self.qtest, "-v", vname, "-f", fname]
        try:
            retcode = subprocess.call(clist)
        except Exception as e:
            x = " ".join(clist)
            print(f"Call of '{x}' failed: {e}")
            return False
        return retcode == 0

    def run(self, tid = 0):
        scoreDict = { k : 0 for k in self.traceDict.keys() }
        print("---\tTrace\t\tPoints")
        if tid == 0:
            tidList = self.traceDict.keys()
        else:
            if not tid in self.traceDict:
                print(f"ERROR: Invalid trace ID {tid}")
                return
            tidList = [tid]
        score = 0
        maxscore = 0
        for t in tidList:
            tname = self.traceDict[t]
            if self.verbLevel > 0:
                print(f"+++ TESTING trace {tname}:")
            ok = self.runTrace(t)
            maxval = self.maxScores[t]
            tval = maxval if ok else 0
            print(f"---\t{tname}\t{tval}/{maxval}")
            score += tval
            maxscore += maxval
            scoreDict[t] = tval
        print(f"---\tTOTAL\t\t{score}/{maxscore}")
        if self.autograde:
            # Generate JSON string
            jstring = '{"scores": {'
            first = True
            for k in scoreDict.keys():
                if not first:
                    jstring += ', '
                first = False
                jstring += f'"{self.traceProbs[k]}" : {scoreDict[k]}'
            jstring += '}}'
            print(jstring)

def usage(name):
    print(f"Usage: {name} [-h] [-p PROG] [-t TID] [-v VLEVEL]")
    print("  -h        Print this message")
    print("  -p PROG   Program to test")
    print("  -t TID    Trace ID to test")
    print("  -v VLEVEL Set verbosity level (0-3)")
    sys.exit(0)

def run(name, args):
    prog = ""
    tid = 0
    vlevel = 1
    levelFixed = False
    autograde = False

    optlist, args = getopt.getopt(args, 'hp:t:v:A')
    for (opt, val) in optlist:
        if opt == '-h':
            usage(name)
        elif opt == '-p':
            prog = val
        elif opt == '-t':
            tid = int(val)
        elif opt == '-v':
            vlevel = int(val)
            levelFixed = True
        elif opt == '-A':
            autograde = True
        else:
            print("Unrecognized option '{opt}'")
            usage(name)
    if not levelFixed and autograde:
        vlevel = 0
    t = Tracer(qtest = prog, verbLevel = vlevel, autograde = autograde)
    t.run(tid)

if __name__ == "__main__":
    run(sys.argv[0], sys.argv[1:])
