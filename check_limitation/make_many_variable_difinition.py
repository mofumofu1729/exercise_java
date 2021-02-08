#!/usr/bin/env python3
# coding: utf-8
import argparse


# 指定された個数の変数定義を生成

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('-n', type=int, required=True)
    args = parser.parse_args()

    for i in range(args.n):
        print("int a{};".format(i+1))


if __name__ == "__main__":
    main()
