OriginalImg = imread('C:\Users\32183\Desktop\MyCode\Digital Image Process\Homework\week5\week5\lena.bmp');
Gray = rgb2gray(OriginalImg);
Gray_fft = fft2(double(Gray));
Gray_fftshift= abs(fftshift(Gray_fft));

PG = angle(Gray_fft);
IFG = ifft2(Gray_fftshift);
IPG = ifft2(exp(j*PG));


figure;
subplot(221);imshow(log(Gray_fftshift+1),[]),title('ͼ��Ƶ�׷���');
subplot(222);imshow(angle(fftshift(Gray_fft)),[]),title('ͼ����λ');
subplot(223);imshow(log(1+abs(IFG)),[]),title('ͼ��Ƶ�׷��ȵ���任');
subplot(224);imshow(IPG,[]),title('ͼ����λ����任');

PQ=paddedsize(size(Gray));
D0=0.05*PQ(1);
HBW=hpfilter('btw',PQ(1),PQ(2),D0,2);
H=0.5+2*HBW;
ghf=dftfilt(Gray,H,'fltpoint'); %enhansed
ghf=gscale(ghf);



d0=20;  %��ֵ
[M ,N]=size(Gray);

img_f = fft2(double(Gray));%����Ҷ�任�õ�Ƶ��
img_f=fftshift(img_f);  %�Ƶ��м�

m_mid=floor(M/2);%���ĵ�����
n_mid=floor(N/2);  

h = zeros(M,N);%��˹��ͨ�˲�������
for i = 1:M
    for j = 1:N
        d = ((i-m_mid)^2+(j-n_mid)^2);
        h(i,j) = exp(-(d)/(2*(d0^2)));      
    end
end

img_lpf = h.*img_f;

img_lpf=ifftshift(img_lpf);    %����ƽ�ƻ�ԭ��״̬
img_lpf=uint8(real(ifft2(img_lpf)));  %������Ҷ�任,ȡʵ������

figure;
subplot(1,2,1);imshow(img_lpf);title('��˹��ͨ�˲�D0=20');
subplot(1,2,2),subimage(ghf)
title('ǿ���˲�')


