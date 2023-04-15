mkdir -p classes
javac -d classes ../src/*.java

cd classes

for i in {1..3}
do
java InputGenerator ../../experiment2/seed$i/input_parameters.prp   ../../experiment2/seed$i/input.in
java InputGenerator ../../experiment2/seed$i/input_parameters.prp   ../../experiment2/seed$i/input.in
java InputGenerator ../../experiment2/seed$i/input_parameters.prp   ../../experiment2/seed$i/input.in
done


#fcfs

java Simulator ../../experiment2/seed1/simulator_parameters_1_fcfs.prp ../../experiment2/seed1/output1fcfs.out ../../experiment2/seed1/input.in
java Simulator ../../experiment2/seed2/simulator_parameters_1_fcfs.prp ../../experiment2/seed2/output1fcfs.out ../../experiment2/seed2/input.in
java Simulator ../../experiment2/seed3/simulator_parameters_1_fcfs.prp ../../experiment2/seed3/output1fcfs.out ../../experiment2/seed3/input.in

#rr
for i in {1..3}
do
java Simulator ../../experiment2/seed$i/simulator_parameters_1_rr.prp ../../experiment2/seed$i/output1rr.out ../../experiment2/seed$i/input.in
java Simulator ../../experiment2/seed$i/simulator_parameters_2_rr.prp ../../experiment2/seed$i/output2rr.out ../../experiment2/seed$i/input.in
java Simulator ../../experiment2/seed$i/simulator_parameters_3_rr.prp ../../experiment2/seed$i/output3rr.out ../../experiment2/seed$i/input.in
java Simulator ../../experiment2/seed$i/simulator_parameters_4_rr.prp ../../experiment2/seed$i/output4rr.out ../../experiment2/seed$i/input.in
java Simulator ../../experiment2/seed$i/simulator_parameters_5_rr.prp ../../experiment2/seed$i/output5rr.out ../../experiment2/seed$i/input.in
done

