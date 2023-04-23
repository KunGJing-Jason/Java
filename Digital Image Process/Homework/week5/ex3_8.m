f=imread('f0319.tif');
PQ=paddedsize(size(f));
D0=0.05*PQ(1);
HBW=hpfilter('btw',PQ(1),PQ(2),D0,2);
H=0.5+2*HBW;
gbw=dftfilt(f,HBW,'fltpoint');
gbw=gscale(gbw); %scales the intensity to [0 255]
ghf=dftfilt(f,H,'fltpoint'); %enhansed
ghf=gscale(ghf);
ghe=histeq(ghf,256);
subplot(2,2,1),subimage(f)
title('Original')
subplot(2,2,2),subimage(gbw)
title('High Pass')
subplot(2,2,3),subimage(ghf)
title('Enhanced HP')
subplot(2,2,4),subimage(ghe)
title('EHP+HistEq')