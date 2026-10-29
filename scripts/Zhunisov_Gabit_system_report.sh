#!/bin/bash
set -o pipefail
cd "$(dirname "$0")/.." || exit 1

{
    echo "Student: Zhunisov Gabit"
    echo "Date and time: $(date)"
    echo "Username: $(whoami)"
    echo "=== Operating system ==="
    cat /etc/os-release
    echo "=== Kernel ==="
    uname -r
    echo "=== CPU ==="
    lscpu
    echo "=== Memory ==="
    free -h
    echo "=== Disk usage and available space ==="
    df -h
    echo "Report completed for Zhunisov Gabit"
} 2>&1 | tee logs/Zhunisov_Gabit_system_report.log
