mkdir -p classes
javac -d classes ../src/*.java

cd classes

for i in {1..5}
do
java InputGenerator ../../experiment1/seed$i/input_parameters_1.prp   ../../experiment1/seed$i/inputs1.in
java InputGenerator ../../experiment1/seed$i/input_parameters_2.prp   ../../experiment1/seed$i/inputs2.in
java InputGenerator ../../experiment1/seed$i/input_parameters_3.prp   ../../experiment1/seed$i/inputs3.in
java InputGenerator ../../experiment1/seed$i/input_parameters_4.prp   ../../experiment1/seed$i/inputs4.in
java InputGenerator ../../experiment1/seed$i/input_parameters_5.prp   ../../experiment1/seed$i/inputs5.in
java InputGenerator ../../experiment1/seed$i/input_parameters_6.prp   ../../experiment1/seed$i/inputs6.in
java InputGenerator ../../experiment1/seed$i/input_parameters_7.prp   ../../experiment1/seed$i/inputs7.in
java InputGenerator ../../experiment1/seed$i/input_parameters_8.prp   ../../experiment1/seed$i/inputs8.in
java InputGenerator ../../experiment1/seed$i/input_parameters_9.prp   ../../experiment1/seed$i/inputs9.in
java InputGenerator ../../experiment1/seed$i/input_parameters_10.prp   ../../experiment1/seed$i/inputs10.in
done


for i in {1..5}
do
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output1.out ../../experiment1/seed$i/inputs1.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output2.out ../../experiment1/seed$i/inputs2.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output3.out ../../experiment1/seed$i/inputs3.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output4.out ../../experiment1/seed$i/inputs4.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output5.out ../../experiment1/seed$i/inputs5.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output6.out ../../experiment1/seed$i/inputs6.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output7.out ../../experiment1/seed$i/inputs7.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output8.out ../../experiment1/seed$i/inputs8.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output9.out ../../experiment1/seed$i/inputs9.in
java Simulator ../../experiment1/seed$i/simulator_parameters.prp ../../experiment1/seed$i/output10.out ../../experiment1/seed$i/inputs10.in
done



