import paramiko
import threading
import time

ip = '115.159.153.43'
user = 'root'
password = 'jj2013914'
jar = 'Qilu2016-0.0.1-SNAPSHOT.jar'
home='/home/springboot/qilu'
current=home+"/current"
releases=home+"/releases"
test = home+"/test"

def execute_cmds(ip, user, passwd, cmd):
    try:
        ssh = paramiko.SSHClient()
        ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        ssh.connect(ip,22,user,passwd,timeout=5)
        for m in cmd:
            print(m)
            stdin, stdout, stderr = ssh.exec_command(m)
            #           stdin.write("Y")
            out = stdout.readlines()
            for o in out:
                print(o),
        print('%s\tOK\n'%(ip))
        ssh.close()
    except :
        print('%s\tError\n'%(ip))


if __name__=='__main__':
    print('Start deploying %s to server %s'%(jar, ip))

    now = time.strftime("%Y%m%d%H%M%S")
    cmd = [
        'cp ' + current + '/' + jar + ' ' + test + '/' + jar,
        'echo Stop spring_integrate_test service... && service spring_integrate_test stop',
        'echo Start spring_integrate_test service... && service spring_integrate_test start',
        'echo Stop spring_integrate service... && service spring_integrate stop',
        'echo Use new jar... ' + \
        ' && mv ' + current + '/' + jar + ' ' + releases + '/' + now + '_' + jar ,
        'mv ' + home + '/' + jar + ' ' + current + '/' + jar,
        'echo Start spring_integrate service... && service spring_integrate start ' + \
        ' && echo All done.'
    ]
    a=threading.Thread(target=execute_cmds, args=(ip,user,password,cmd))
    a.start()
