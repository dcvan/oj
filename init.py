def parse_argv(argv):
    # use sys.argv[1:] to substitute argv
    import argparse

    parser = argparse.ArgumentParser(description='Description here.')
    parser.add_argument('file')
    args = parser.parse_args(argv)
    return args


def gen_init_file(f):
    with open(f, 'w') as fr:
        fr.write("""#include<iostream>

using namespace std;

int
main(int argn, char *argv[])
{
    return 0;
}
""")


if __name__ == "__main__":
    import sys
    args = parse_argv(sys.argv[1:])
    gen_init_file(args.file)
